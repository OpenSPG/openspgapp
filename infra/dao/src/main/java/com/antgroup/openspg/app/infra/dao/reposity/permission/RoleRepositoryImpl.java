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

import com.antgroup.openspg.app.base.permission.RoleRepository;
import com.antgroup.openspg.app.base.permission.model.Role;
import com.antgroup.openspg.app.infra.dao.dataobject.permission.RoleDO;
import com.antgroup.openspg.app.infra.dao.mapper.RoleMapper;
import com.antgroup.openspg.app.infra.dao.reposity.permission.convertor.RoleConvertor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

  @Autowired private RoleMapper roleMapper;

  @Override
  public List<Role> selectAllRoleName() {
    RoleDO roleDO = new RoleDO();
    List<RoleDO> roleDOList = roleMapper.selectByCondition(roleDO, 0, Integer.MAX_VALUE);
    return Optional.ofNullable(roleDOList).orElse(new ArrayList<>()).stream()
        .filter(Objects::nonNull)
        .map(RoleConvertor::toRole)
        .collect(Collectors.toList());
  }

  @Override
  public Role selectByRoleName(String roleName) {
    RoleDO roleDO = roleMapper.selectByRoleName(roleName);
    return RoleConvertor.toRole(roleDO);
  }
}
