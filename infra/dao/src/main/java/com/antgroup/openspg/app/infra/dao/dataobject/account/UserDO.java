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
package com.antgroup.openspg.app.infra.dao.dataobject.account;

import java.util.Date;

/** This model corresponds to the database table: kg_user Database Table Remarks: */
public class UserDO {
  /** 主键 */
  private Long id;

  /** 创建时间 */
  private Date gmtCreate;

  /** 修改时间 */
  private Date gmtModified;

  /** 用户工号 */
  private String userNo;

  /** token */
  private String token;

  /** 修改前token */
  private String lastToken;

  /** 随机字符串 */
  private String salt;

  /** token修改时间 */
  private Date gmtLastTokenDisable;

  /** 数仓用户ID */
  private String dwAccessId;

  /** 数仓用户密钥 */
  private String dwAccessKey;

  /** 用户真名 */
  private String realName;

  /** 用户花名 */
  private String nickName;

  /** 用户邮箱 */
  private String email;

  /** 用户域账号 */
  private String domainAccount;

  /** 用户手机号 */
  private String mobile;

  /** 用户微信账号 */
  private String wxAccount;

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column kg_user.id
   *
   * @return the value of kg_user.id
   * @mbg.generated Mon Nov 30 23:24:07 CST 2020
   */
  public Long getId() {
    return id;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column kg_user.id
   *
   * @param id the value for kg_user.id
   * @mbg.generated Mon Nov 30 23:24:07 CST 2020
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column kg_user.gmt_create
   *
   * @return the value of kg_user.gmt_create
   * @mbg.generated Mon Nov 30 23:24:07 CST 2020
   */
  public Date getGmtCreate() {
    return gmtCreate;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column kg_user.gmt_create
   *
   * @param gmtCreate the value for kg_user.gmt_create
   * @mbg.generated Mon Nov 30 23:24:07 CST 2020
   */
  public void setGmtCreate(Date gmtCreate) {
    this.gmtCreate = gmtCreate;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column kg_user.gmt_modified
   *
   * @return the value of kg_user.gmt_modified
   * @mbg.generated Mon Nov 30 23:24:07 CST 2020
   */
  public Date getGmtModified() {
    return gmtModified;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column kg_user.gmt_modified
   *
   * @param gmtModified the value for kg_user.gmt_modified
   * @mbg.generated Mon Nov 30 23:24:07 CST 2020
   */
  public void setGmtModified(Date gmtModified) {
    this.gmtModified = gmtModified;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column kg_user.user_no
   *
   * @return the value of kg_user.user_no
   * @mbg.generated Mon Nov 30 23:24:07 CST 2020
   */
  public String getUserNo() {
    return userNo;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column kg_user.user_no
   *
   * @param userNo the value for kg_user.user_no
   * @mbg.generated Mon Nov 30 23:24:07 CST 2020
   */
  public void setUserNo(String userNo) {
    this.userNo = userNo;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column kg_user.token
   *
   * @return the value of kg_user.token
   * @mbg.generated Mon Nov 30 23:24:07 CST 2020
   */
  public String getToken() {
    return token;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column kg_user.token
   *
   * @param token the value for kg_user.token
   * @mbg.generated Mon Nov 30 23:24:07 CST 2020
   */
  public void setToken(String token) {
    this.token = token;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column kg_user.last_token
   *
   * @return the value of kg_user.last_token
   * @mbg.generated Mon Nov 30 23:24:07 CST 2020
   */
  public String getLastToken() {
    return lastToken;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column kg_user.last_token
   *
   * @param lastToken the value for kg_user.last_token
   * @mbg.generated Mon Nov 30 23:24:07 CST 2020
   */
  public void setLastToken(String lastToken) {
    this.lastToken = lastToken;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column kg_user.salt
   *
   * @return the value of kg_user.salt
   * @mbg.generated Mon Nov 30 23:24:07 CST 2020
   */
  public String getSalt() {
    return salt;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column kg_user.salt
   *
   * @param salt the value for kg_user.salt
   * @mbg.generated Mon Nov 30 23:24:07 CST 2020
   */
  public void setSalt(String salt) {
    this.salt = salt;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column kg_user.gmt_last_token_disable
   *
   * @return the value of kg_user.gmt_last_token_disable
   * @mbg.generated Mon Nov 30 23:24:07 CST 2020
   */
  public Date getGmtLastTokenDisable() {
    return gmtLastTokenDisable;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column kg_user.gmt_last_token_disable
   *
   * @param gmtLastTokenDisable the value for kg_user.gmt_last_token_disable
   * @mbg.generated Mon Nov 30 23:24:07 CST 2020
   */
  public void setGmtLastTokenDisable(Date gmtLastTokenDisable) {
    this.gmtLastTokenDisable = gmtLastTokenDisable;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column kg_user.dw_access_id
   *
   * @return the value of kg_user.dw_access_id
   * @mbg.generated Mon Nov 30 23:24:07 CST 2020
   */
  public String getDwAccessId() {
    return dwAccessId;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column kg_user.dw_access_id
   *
   * @param dwAccessId the value for kg_user.dw_access_id
   * @mbg.generated Mon Nov 30 23:24:07 CST 2020
   */
  public void setDwAccessId(String dwAccessId) {
    this.dwAccessId = dwAccessId;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column kg_user.dw_access_key
   *
   * @return the value of kg_user.dw_access_key
   * @mbg.generated Mon Nov 30 23:24:07 CST 2020
   */
  public String getDwAccessKey() {
    return dwAccessKey;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column kg_user.dw_access_key
   *
   * @param dwAccessKey the value for kg_user.dw_access_key
   * @mbg.generated Mon Nov 30 23:24:07 CST 2020
   */
  public void setDwAccessKey(String dwAccessKey) {
    this.dwAccessKey = dwAccessKey;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column kg_user.real_name
   *
   * @return the value of kg_user.real_name
   * @mbg.generated Mon Nov 30 23:24:07 CST 2020
   */
  public String getRealName() {
    return realName;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column kg_user.real_name
   *
   * @param realName the value for kg_user.real_name
   * @mbg.generated Mon Nov 30 23:24:07 CST 2020
   */
  public void setRealName(String realName) {
    this.realName = realName;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column kg_user.nick_name
   *
   * @return the value of kg_user.nick_name
   * @mbg.generated Mon Nov 30 23:24:07 CST 2020
   */
  public String getNickName() {
    return nickName;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column kg_user.nick_name
   *
   * @param nickName the value for kg_user.nick_name
   * @mbg.generated Mon Nov 30 23:24:07 CST 2020
   */
  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDomainAccount() {
    return domainAccount;
  }

  public void setDomainAccount(String domainAccount) {
    this.domainAccount = domainAccount;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getWxAccount() {
    return wxAccount;
  }

  public void setWxAccount(String wxAccount) {
    this.wxAccount = wxAccount;
  }
}
