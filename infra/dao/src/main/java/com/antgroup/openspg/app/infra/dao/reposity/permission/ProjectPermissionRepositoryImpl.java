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

import com.antgroup.openspg.app.base.permission.ProjectPermissionRepository;
import com.antgroup.openspg.app.base.permission.model.ProjectPermission;
import com.antgroup.openspg.app.infra.dao.dataobject.permission.ProjectMemberRoleInfoDO;
import com.antgroup.openspg.app.infra.dao.mapper.ProjectMemberRoleInfoMapper;
import com.antgroup.openspg.app.infra.dao.reposity.permission.convertor.ProjectPermissionConvertor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectPermissionRepositoryImpl implements ProjectPermissionRepository {

  @Autowired private ProjectMemberRoleInfoMapper kgProjectMemberRoleInfoMapper;

  @Override
  public int upsert(ProjectPermission projectPermission) {
    int count;
    ProjectMemberRoleInfoDO roleInfoDO =
        ProjectPermissionConvertor.toProjectPermissionDO(projectPermission);
    if (null == roleInfoDO.getId()) {
      roleInfoDO.setGmtCreate(new Date());
      roleInfoDO.setGmtModified(new Date());
      count = kgProjectMemberRoleInfoMapper.insert(roleInfoDO);
    } else {
      roleInfoDO.setGmtModified(new Date());
      count = kgProjectMemberRoleInfoMapper.updateByPrimaryKeySelective(roleInfoDO);
    }
    return count;
  }

  @Override
  public int deleteById(Long id) {
    return kgProjectMemberRoleInfoMapper.deleteByPrimaryKey(id);
  }

  @Override
  public int removeProjectPermission(String userId, Long projectId) {
    return kgProjectMemberRoleInfoMapper.deleteByProjectIdAndUserId(userId, projectId);
  }

  @Override
  public int removeAllProjectPermission(Long projectId) {
    return kgProjectMemberRoleInfoMapper.deleteByProjectId(projectId);
  }

  @Override
  public List<ProjectPermission> queryByCondition(ProjectPermission projectPermission) {
    ProjectMemberRoleInfoDO roleInfoDO =
        ProjectPermissionConvertor.toProjectPermissionDO(projectPermission);
    List<ProjectMemberRoleInfoDO> roleInfoDOList =
        kgProjectMemberRoleInfoMapper.selectAllByCondition(roleInfoDO);
    return Optional.ofNullable(roleInfoDOList).orElse(new ArrayList<>()).stream()
        .map(ProjectPermissionConvertor::toProjectPermission)
        .filter(Objects::nonNull)
        .collect(Collectors.toList());
  }
}
