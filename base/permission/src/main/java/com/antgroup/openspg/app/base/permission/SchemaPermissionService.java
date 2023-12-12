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

package com.antgroup.openspg.app.base.permission;

import java.util.List;

/** the permission of the schema */
public interface SchemaPermissionService {

  /**
   * verify the role
   *
   * @param userId
   * @param resourceId
   * @param resourceTypeEnum
   * @param roleTypeEnum
   * @return
   */
  Boolean verifyRole(
      String userId, Long resourceId, ResourceTypeEnum resourceTypeEnum, RoleTypeEnum roleTypeEnum);

  /**
   * grant role
   *
   * @param token
   * @param userIds
   * @param resourceIds
   * @param resourceTypeEnum
   * @param roleTypeEnum
   * @return
   */
  Integer addResourceRole(
      String token,
      List<String> userIds,
      List<Long> resourceIds,
      ResourceTypeEnum resourceTypeEnum,
      RoleTypeEnum roleTypeEnum)
      throws Exception;

  /**
   * remove the role
   *
   * @param token
   * @param userIds
   * @param resourceIds
   * @return
   */
  Integer removeRole(
      String token, List<Long> userIds, List<Long> resourceIds, ResourceTypeEnum resourceTypeEnum)
      throws Exception;
}
