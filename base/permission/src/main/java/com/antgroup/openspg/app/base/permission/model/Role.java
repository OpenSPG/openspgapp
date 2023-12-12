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

package com.antgroup.openspg.app.base.permission.model;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable {

  /** 主键，角色id */
  private Long id;

  /** 创建时间 */
  private Date gmtCreate;

  /** 修改时间 */
  private Date gmtModified;

  /** 角色名 */
  private String roleName;

  /** 角色权限具体信息，json格式 */
  private String permissionDetail;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getGmtCreate() {
    return gmtCreate;
  }

  public void setGmtCreate(Date gmtCreate) {
    this.gmtCreate = gmtCreate;
  }

  public Date getGmtModified() {
    return gmtModified;
  }

  public void setGmtModified(Date gmtModified) {
    this.gmtModified = gmtModified;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public String getPermissionDetail() {
    return permissionDetail;
  }

  public void setPermissionDetail(String permissionDetail) {
    this.permissionDetail = permissionDetail;
  }
}
