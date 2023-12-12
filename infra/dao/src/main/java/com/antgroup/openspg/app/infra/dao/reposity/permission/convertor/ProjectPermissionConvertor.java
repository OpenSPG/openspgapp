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

import com.antgroup.openspg.app.base.permission.model.ProjectPermission;
import com.antgroup.openspg.app.infra.dao.dataobject.permission.ProjectMemberRoleInfoDO;

public class ProjectPermissionConvertor {

  /**
   * to db projectPermission object
   *
   * @param projectPermission
   * @return
   */
  public static ProjectMemberRoleInfoDO toProjectPermissionDO(ProjectPermission projectPermission) {
    ProjectMemberRoleInfoDO roleInfoDO = new ProjectMemberRoleInfoDO();
    if (null == projectPermission) {
      return roleInfoDO;
    }
    roleInfoDO.setId(projectPermission.getId());
    roleInfoDO.setProjectId(projectPermission.getProjectId());
    roleInfoDO.setRoleId(projectPermission.getRoleId());
    roleInfoDO.setStatus(projectPermission.getStatus());
    roleInfoDO.setUserNo(projectPermission.getUserNo());
    return roleInfoDO;
  }

  public static ProjectPermission toProjectPermission(
      ProjectMemberRoleInfoDO projectMemberRoleInfoDO) {
    ProjectPermission projectPermission = new ProjectPermission();
    if (null == projectMemberRoleInfoDO) {
      return projectPermission;
    }
    projectPermission.setId(projectMemberRoleInfoDO.getId());
    projectPermission.setRoleId(projectMemberRoleInfoDO.getRoleId());
    projectPermission.setUserNo(projectMemberRoleInfoDO.getUserNo());
    projectPermission.setStatus(projectMemberRoleInfoDO.getStatus());
    projectPermission.setProjectId(projectMemberRoleInfoDO.getProjectId());
    return projectPermission;
  }
}
