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

/**
 *   * Alipay.com Inc.  * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.antgroup.openspg.app.infra.dao.mapper;

import com.antgroup.openspg.app.infra.dao.dataobject.permission.RoleDO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleMapper {
  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * kg_role
   *
   * @param record com.alipay.kgmng.common.dal.mybatis.po.KgRolePO
   * @return int
   */
  int insert(RoleDO record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * kg_role
   *
   * @param id java.lang.Long
   * @return int
   */
  int deleteByPrimaryKey(Long id);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * kg_role
   *
   * @param ids List<Long>
   * @return int
   */
  int deleteByIds(@Param("ids") List<Long> ids);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * kg_role
   *
   * @param record com.alipay.kgmng.common.dal.mybatis.po.KgRolePO
   * @return int
   */
  int updateByPrimaryKeySelective(RoleDO record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * kg_role
   *
   * @param id java.lang.Long
   * @return com.alipay.kgmng.common.dal.mybatis.po.KgRolePO
   */
  RoleDO selectByPrimaryKey(Long id);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * kg_role
   *
   * @param record com.alipay.kgmng.common.dal.mybatis.po.KgRolePO
   * @param start int
   * @param size int
   * @return List<KgRolePO>
   */
  List<RoleDO> selectByCondition(
      @Param("record") RoleDO record, @Param("start") int start, @Param("size") int size);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * kg_role
   *
   * @param record com.alipay.kgmng.common.dal.mybatis.po.KgRolePO
   * @return int
   */
  int selectCountByCondition(RoleDO record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * kg_role
   *
   * @param ids List<Long>
   * @return List<KgRolePO>
   */
  List<RoleDO> selectByIds(@Param("ids") List<Long> ids);

  /**
   * roleName
   *
   * @param roleName
   * @return
   */
  RoleDO selectByRoleName(@Param("roleName") String roleName);
}
