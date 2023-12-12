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

import com.antgroup.openspg.app.base.permission.model.ProjectPermission;
import java.util.List;

/** The repository service for projectPermission */
public interface ProjectPermissionRepository {

  /**
   * add or update projectPermission
   *
   * @param projectPermission
   * @return
   */
  int upsert(ProjectPermission projectPermission);

  /**
   * delete projectPermission by id
   *
   * @param id
   * @return
   */
  int deleteById(Long id);

  /**
   * remove the userId
   *
   * @param userId
   * @param projectId
   * @return
   */
  int removeProjectPermission(String userId, Long projectId);

  /**
   * remove all permission for the project
   *
   * @param projectId
   * @return
   */
  int removeAllProjectPermission(Long projectId);

  /**
   * query projectPermission by conditions
   *
   * @param projectPermission
   * @return
   */
  List<ProjectPermission> queryByCondition(ProjectPermission projectPermission);
}
