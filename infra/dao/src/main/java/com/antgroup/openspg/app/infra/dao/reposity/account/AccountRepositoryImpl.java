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

package com.antgroup.openspg.app.infra.dao.reposity.account;

import com.antgroup.openspg.app.base.account.AccountRepository;
import com.antgroup.openspg.app.base.account.model.User;
import com.antgroup.openspg.app.infra.dao.dataobject.account.UserDO;
import com.antgroup.openspg.app.infra.dao.mapper.UserMapper;
import com.antgroup.openspg.app.infra.dao.reposity.account.convertor.UserConvertor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

  @Autowired private UserMapper userMapper;

  @Override
  public Integer upsert(User user) {
    UserDO userDO = UserConvertor.toUserDO(user);
    userDO.setGmtModified(new Date());
    int count;
    if (null == userDO.getId()) {
      userDO.setGmtCreate(new Date());
      count = userMapper.insert(userDO);
    } else {
      count = userMapper.updateByPrimaryKeySelective(userDO);
    }
    return count;
  }

  @Override
  public List<User> queryLike(String keyword) {
    List<UserDO> userDOList = userMapper.getUserLikeUserNoOrDomainNoOrName(keyword);
    return Optional.ofNullable(userDOList).orElse(new ArrayList<>()).stream()
        .filter(Objects::nonNull)
        .map(UserConvertor::toUser)
        .collect(Collectors.toList());
  }

  @Override
  public User queryByToken(String token) {
    UserDO userDO = new UserDO();
    userDO.setToken(token);
    List<UserDO> userDOList = userMapper.selectByCondition(userDO, 0, 1);
    return Optional.ofNullable(userDOList).orElse(new ArrayList<>()).stream()
        .filter(Objects::nonNull)
        .map(UserConvertor::toUser)
        .collect(Collectors.toList())
        .get(0);
  }
}
