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

package com.antgroup.openspg.app.infra.dao.reposity.permission;

import com.antgroup.openspg.app.base.permission.ResourceTypeEnum;
import com.antgroup.openspg.app.base.permission.SchemaPermissionRepository;
import com.antgroup.openspg.app.base.permission.model.SchemaPermission;
import com.antgroup.openspg.app.infra.dao.dataobject.permission.UserResourceRoleDO;
import com.antgroup.openspg.app.infra.dao.mapper.UserResourceRoleMapper;
import com.antgroup.openspg.app.infra.dao.reposity.permission.convertor.SchemaPermissionConvertor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

@Repository
public class SchemaPermissionRepositoryImpl implements SchemaPermissionRepository {

  @Autowired private UserResourceRoleMapper kgUserResourceRoleMapper;

  @Override
  public int upsert(SchemaPermission schemaPermission) {
    UserResourceRoleDO userResourceRoleDO =
        SchemaPermissionConvertor.toUserResourceRoleDO(schemaPermission);
    int count;
    userResourceRoleDO.setGmtModified(new Date());
    if (null == userResourceRoleDO.getId()) {
      userResourceRoleDO.setGmtCreate(new Date());
      count = kgUserResourceRoleMapper.insert(userResourceRoleDO);
    } else {
      count = kgUserResourceRoleMapper.updateByPrimaryKeySelective(userResourceRoleDO);
    }
    return count;
  }

  @Override
  public int batchInsert(List<SchemaPermission> schemaPermissionList) {
    List<UserResourceRoleDO> userResourceRoleDOList =
        schemaPermissionList.stream()
            .map(SchemaPermissionConvertor::toUserResourceRoleDO)
            .collect(Collectors.toList());
    for (UserResourceRoleDO resourceRoleDO : userResourceRoleDOList) {
      resourceRoleDO.setGmtCreate(new Date());
      resourceRoleDO.setGmtModified(new Date());
      resourceRoleDO.setStatus("1");
    }
    return kgUserResourceRoleMapper.batchInsert(userResourceRoleDOList);
  }

  @Override
  public int deleteById(Long id) {
    return kgUserResourceRoleMapper.deleteByPrimaryKey(id);
  }

  @Override
  public int batchRemove(
      List<Long> userIds, List<Long> resourceIds, ResourceTypeEnum resourceTypeEnum) {
    if (CollectionUtils.isEmpty(userIds) || CollectionUtils.isEmpty(resourceIds)) {
      return 0;
    }
    return kgUserResourceRoleMapper.deleteByResourceIds(
        userIds, resourceIds, resourceTypeEnum.name());
  }

  @Override
  public List<SchemaPermission> queryByCondition(SchemaPermission schemaPermission) {
    UserResourceRoleDO resourceRoleDO =
        SchemaPermissionConvertor.toUserResourceRoleDO(schemaPermission);
    List<UserResourceRoleDO> resourceRoleDOList =
        kgUserResourceRoleMapper.selectAllByCondition(resourceRoleDO);
    return convertSchemaPermission(resourceRoleDOList);
  }

  @Override
  public List<SchemaPermission> queryByResourceIds(
      List<Long> resourceIds, ResourceTypeEnum resourceTypeEnum) {
    if (CollectionUtils.isEmpty(resourceIds)) {
      return new ArrayList<>();
    }
    List<UserResourceRoleDO> resourceRoleDOList =
        kgUserResourceRoleMapper.selectByResources(resourceIds, resourceTypeEnum.name());
    return convertSchemaPermission(resourceRoleDOList);
  }

  private List<SchemaPermission> convertSchemaPermission(
      List<UserResourceRoleDO> userResourceRoleDOList) {
    return Optional.ofNullable(userResourceRoleDOList).orElse(new ArrayList<>()).stream()
        .map(SchemaPermissionConvertor::toSchemaPermission)
        .filter(Objects::nonNull)
        .collect(Collectors.toList());
  }
}
