/*
 * Copyright 2023 Ant Group CO., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied.
 */

package com.antgroup.openspg.app.base.permission.impl;

import com.antgroup.openspg.app.base.account.AccountRepository;
import com.antgroup.openspg.app.base.account.model.User;
import com.antgroup.openspg.app.base.permission.ResourceTypeEnum;
import com.antgroup.openspg.app.base.permission.RoleRepository;
import com.antgroup.openspg.app.base.permission.RoleTypeEnum;
import com.antgroup.openspg.app.base.permission.SchemaPermissionRepository;
import com.antgroup.openspg.app.base.permission.SchemaPermissionService;
import com.antgroup.openspg.app.base.permission.model.Role;
import com.antgroup.openspg.app.base.permission.model.SchemaPermission;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class SchemaPermissionServiceImpl implements SchemaPermissionService {

  @Autowired private SchemaPermissionRepository schemaPermissionRepository;

  @Autowired private AccountRepository accountRepository;

  @Autowired private RoleRepository roleRepository;

  @Override
  public Boolean verifyRole(
      String userId,
      Long resourceId,
      ResourceTypeEnum resourceTypeEnum,
      RoleTypeEnum roleTypeEnum) {
    SchemaPermission schemaPermission = new SchemaPermission();
    schemaPermission.setUserNo(userId);
    schemaPermission.setResourceId(resourceId);
    schemaPermission.setResourceTag(resourceTypeEnum.name());
    List<SchemaPermission> schemaPermissionList =
        schemaPermissionRepository.queryByCondition(schemaPermission);
    if (CollectionUtils.isEmpty(schemaPermissionList)) {
      return false;
    }
    Role role = roleRepository.selectByRoleName(roleTypeEnum.name());
    return schemaPermissionList.get(0).getRoleId().equals(role.getId());
  }

  @Override
  public Integer addResourceRole(
      String token,
      List<String> userIds,
      List<Long> resourceIds,
      ResourceTypeEnum resourceTypeEnum,
      RoleTypeEnum roleTypeEnum)
      throws Exception {
    checkOwner(token, resourceIds, resourceTypeEnum);
    Role role = roleRepository.selectByRoleName(roleTypeEnum.name());
    List<SchemaPermission> permissionList = new ArrayList<>();
    SchemaPermission schemaPermission;
    for (String userId : userIds) {
      schemaPermission = new SchemaPermission();
      for (Long resourceId : resourceIds) {
        schemaPermission.setUserNo(userId);
        schemaPermission.setResourceId(resourceId);
        schemaPermission.setResourceTag(resourceTypeEnum.name());
        schemaPermission.setRoleId(role.getId());
        permissionList.add(schemaPermission);
      }
    }
    return schemaPermissionRepository.batchInsert(permissionList);
  }

  @Override
  public Integer removeRole(
      String token, List<Long> userIds, List<Long> resourceIds, ResourceTypeEnum resourceTypeEnum)
      throws Exception {
    checkOwner(token, resourceIds, resourceTypeEnum);
    return schemaPermissionRepository.batchRemove(userIds, resourceIds, resourceTypeEnum);
  }

  private void checkOwner(String token, List<Long> resourceIds, ResourceTypeEnum resourceTypeEnum)
      throws Exception {
    User user = accountRepository.queryByToken(token);
    if (null == user) {
      throw new Exception("invalid user");
    }

    List<SchemaPermission> schemaPermissionList =
        schemaPermissionRepository.queryByResourceIds(resourceIds, resourceTypeEnum);
    if (resourceIds.size() != schemaPermissionList.size()) {
      throw new Exception("need the resourceId owner");
    }
  }
}
