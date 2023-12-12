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

import com.antgroup.openspg.app.base.permission.model.Role;
import java.util.List;

public interface RoleRepository {

  /**
   * 获取所有的角色
   *
   * @return
   */
  List<Role> selectAllRoleName();

  /**
   * 根据角色名称查询
   *
   * @param roleName
   * @return
   */
  Role selectByRoleName(String roleName);
}
