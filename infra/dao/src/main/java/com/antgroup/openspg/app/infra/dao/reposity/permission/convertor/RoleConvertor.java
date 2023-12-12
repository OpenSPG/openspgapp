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

import com.antgroup.openspg.app.base.permission.model.Role;
import com.antgroup.openspg.app.infra.dao.dataobject.permission.RoleDO;

public class RoleConvertor {

  /**
   * to role
   *
   * @param roleDO
   * @return
   */
  public static Role toRole(RoleDO roleDO) {
    Role role = new Role();
    if (null == roleDO) {
      return role;
    }
    role.setId(roleDO.getId());
    role.setRoleName(roleDO.getRoleName());
    return role;
  }
}
