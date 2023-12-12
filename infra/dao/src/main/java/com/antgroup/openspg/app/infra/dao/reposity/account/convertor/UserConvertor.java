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

package com.antgroup.openspg.app.infra.dao.reposity.account.convertor;

import com.antgroup.openspg.app.base.account.model.User;
import com.antgroup.openspg.app.infra.dao.dataobject.account.UserDO;

public class UserConvertor {

  /**
   * to user
   *
   * @param userDO
   * @return
   */
  public static User toUser(UserDO userDO) {
    User user = new User();
    if (null == userDO) {
      return user;
    }
    user.setId(userDO.getId());
    user.setWorkNo(userDO.getUserNo());
    user.setNickName(userDO.getNickName());
    user.setRealName(userDO.getRealName());
    user.setLoginAccount(userDO.getDomainAccount());
    user.setEmail(userDO.getEmail());
    user.setMobile(userDO.getMobile());
    user.setToken(userDO.getToken());
    return user;
  }

  /**
   * to db user object
   *
   * @param user
   * @return
   */
  public static UserDO toUserDO(User user) {
    UserDO userDO = new UserDO();
    if (null == user) {
      return userDO;
    }
    userDO.setId(user.getId());
    userDO.setNickName(user.getNickName());
    userDO.setRealName(user.getRealName());
    userDO.setDomainAccount(user.getLoginAccount());
    userDO.setToken(user.getToken());
    userDO.setEmail(user.getEmail());
    userDO.setUserNo(user.getWorkNo());
    return userDO;
  }
}
