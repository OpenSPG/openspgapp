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

/** the kg permission of project */
public interface ProjectPermissionService {

  /**
   * verify the role
   *
   * @param userId
   * @param projectId
   * @return
   */
  Boolean verifyRole(String userId, Long projectId, RoleTypeEnum roleTypeEnum);

  /**
   * add project permission
   *
   * @param token the token of an operator with owner role
   * @param userId
   * @param projectId
   * @param roleTypeEnum
   * @return
   */
  Integer addProjectPermission(
      String token, String userId, Long projectId, RoleTypeEnum roleTypeEnum) throws Exception;

  /**
   * remove project permission
   *
   * @param token the token of an operator with owner role
   * @param userId
   * @param projectId
   * @return
   */
  Integer removeProjectPermission(String token, String userId, Long projectId) throws Exception;

  /**
   * remove all project permission
   *
   * @param token
   * @param projectId
   * @return
   */
  Integer deleteAllProjectPermission(String token, Long projectId) throws Exception;
}
