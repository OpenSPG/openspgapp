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

/** the kg role type */
public enum RoleTypeEnum {

  /** owner of project or resource */
  OWNER(2),

  /** project member */
  MEMBER(20),

  /** resource read permission */
  R_MEMBER(30),

  /** resource write permission */
  W_MEMBER(10),

  /** the plaintext permission */
  VISIBLE(500);

  int level;

  private RoleTypeEnum(int level) {
    this.level = level;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }
}
