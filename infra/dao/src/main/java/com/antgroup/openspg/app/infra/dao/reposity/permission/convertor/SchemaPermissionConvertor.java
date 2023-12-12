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

package com.antgroup.openspg.app.infra.dao.reposity.permission.convertor;

import com.antgroup.openspg.app.base.permission.model.SchemaPermission;
import com.antgroup.openspg.app.infra.dao.dataobject.permission.UserResourceRoleDO;

public class SchemaPermissionConvertor {

  /**
   * to db resourceRole object
   *
   * @param schemaPermission
   * @return
   */
  public static UserResourceRoleDO toUserResourceRoleDO(SchemaPermission schemaPermission) {
    UserResourceRoleDO resourceRoleDO = new UserResourceRoleDO();
    if (null == schemaPermission) {
      return resourceRoleDO;
    }
    resourceRoleDO.setId(schemaPermission.getId());
    resourceRoleDO.setResourceId(schemaPermission.getResourceId());
    resourceRoleDO.setRoleId(schemaPermission.getRoleId());
    resourceRoleDO.setUserNo(schemaPermission.getUserNo());
    resourceRoleDO.setStatus(schemaPermission.getStatus());
    resourceRoleDO.setResourceTag(schemaPermission.getResourceTag());
    return resourceRoleDO;
  }

  /**
   * to resourceRole
   *
   * @param userResourceRoleDO
   * @return
   */
  public static SchemaPermission toSchemaPermission(UserResourceRoleDO userResourceRoleDO) {
    SchemaPermission schemaPermission = new SchemaPermission();
    if (null == userResourceRoleDO) {
      return schemaPermission;
    }
    schemaPermission.setId(userResourceRoleDO.getId());
    schemaPermission.setRoleId(userResourceRoleDO.getRoleId());
    schemaPermission.setResourceTag(userResourceRoleDO.getResourceTag());
    schemaPermission.setStatus(userResourceRoleDO.getStatus());
    schemaPermission.setResourceId(userResourceRoleDO.getResourceId());
    schemaPermission.setUserNo(userResourceRoleDO.getUserNo());
    return schemaPermission;
  }
}
