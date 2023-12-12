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

package com.antgroup.openspg.app.base.account.model;

import java.io.Serializable;

public class User implements Serializable {

  /** id */
  private Long id;

  /** 花名 */
  private String nickName;

  /** 域账号 */
  private String loginAccount;

  /** 真名 */
  private String realName;

  /** 工号 */
  private String workNo;

  /** 邮件 */
  private String email;

  /** 证件照 */
  private String employeeCardPic;

  /** 手机号 */
  private String mobile;

  /** 主管工号 */
  private String superWorkNo;

  /** token */
  private String token;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public String getLoginAccount() {
    return loginAccount;
  }

  public void setLoginAccount(String loginAccount) {
    this.loginAccount = loginAccount;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public String getWorkNo() {
    return workNo;
  }

  public void setWorkNo(String workNo) {
    this.workNo = workNo;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmployeeCardPic() {
    return employeeCardPic;
  }

  public void setEmployeeCardPic(String employeeCardPic) {
    this.employeeCardPic = employeeCardPic;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getSuperWorkNo() {
    return superWorkNo;
  }

  public void setSuperWorkNo(String superWorkNo) {
    this.superWorkNo = superWorkNo;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
