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

import com.antgroup.openspg.app.base.permission.model.SchemaPermission;
import java.util.List;

public interface SchemaPermissionRepository {

  /**
   * add or update schemaPermission
   *
   * @param schemaPermission
   * @return
   */
  int upsert(SchemaPermission schemaPermission);

  /**
   * batch insert schemaPermission
   *
   * @param schemaPermissionList
   * @return
   */
  int batchInsert(List<SchemaPermission> schemaPermissionList);

  /**
   * delete schemaPermission by id
   *
   * @param id
   * @return
   */
  int deleteById(Long id);

  /**
   * batch remove schemaPermission
   *
   * @param userIds
   * @param resourceIds
   * @param resourceTypeEnum
   * @return
   */
  int batchRemove(List<Long> userIds, List<Long> resourceIds, ResourceTypeEnum resourceTypeEnum);

  /**
   * query schemaPermission by conditions
   *
   * @param schemaPermission
   * @return
   */
  List<SchemaPermission> queryByCondition(SchemaPermission schemaPermission);

  /**
   * batch query by resourceIds
   *
   * @param resourceIds
   * @param resourceTypeEnum
   * @return
   */
  List<SchemaPermission> queryByResourceIds(
      List<Long> resourceIds, ResourceTypeEnum resourceTypeEnum);
}
