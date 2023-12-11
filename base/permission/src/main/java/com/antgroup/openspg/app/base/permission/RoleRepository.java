package com.antgroup.openspg.app.base.permission;

import java.util.List;

import com.antgroup.openspg.app.base.permission.model.Role;

public interface RoleRepository {

    /**
     * 获取所有的角色
     * @return
     */
    List<Role> selectAllRoleName();

    /**
     * 根据角色名称查询
     * @param roleName
     * @return
     */
    Role selectByRoleName(String roleName);
}
