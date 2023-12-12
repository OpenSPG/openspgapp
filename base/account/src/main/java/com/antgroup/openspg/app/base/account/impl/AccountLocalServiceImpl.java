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

package com.antgroup.openspg.app.base.account.impl;

import com.antgroup.openspg.app.base.account.AccountRepository;
import com.antgroup.openspg.app.base.account.AccountService;
import com.antgroup.openspg.app.base.account.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class AccountLocalServiceImpl implements AccountService {

  @Autowired private AccountRepository accountRepository;

  @Override
  public User getUserInfoByWorkNo(String workNo) {
    User user = null;
    try {
      user = getUser(workNo);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return user;
  }

  @Override
  public User getUserInfoByLoginAccount(String account) throws Exception {
    return getUser(account);
  }

  @Override
  public List<User> getUserInfoListByKeyword(String keyword) throws Exception {
    List<User> userList = accountRepository.queryLike(keyword);
    if (CollectionUtils.isEmpty(userList)) {
      throw new Exception("user not found");
    }
    return userList;
  }

  @Override
  public User getLoginUser() {
    return buildMockOperator();
  }

  @Override
  public Boolean haveSuperPermission() {
    return true;
  }

  @Override
  public String logout(String redirectUrl) {
    return null;
  }

  private User buildMockOperator() {
    User operator = new User();
    operator.setLoginAccount("知测");
    operator.setRealName("知测");
    operator.setId(141964L);
    operator.setNickName("知测");
    return operator;
  }

  private User getUser(String keyword) throws Exception {
    List<User> userList = accountRepository.queryLike(keyword);
    if (CollectionUtils.isEmpty(userList)) {
      throw new Exception("user not found");
    }
    return userList.get(0);
  }
}
