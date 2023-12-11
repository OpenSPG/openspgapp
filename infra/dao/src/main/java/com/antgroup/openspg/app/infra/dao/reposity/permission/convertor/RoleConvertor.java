package com.antgroup.openspg.app.infra.dao.reposity.permission.convertor;

import com.antgroup.openspg.app.base.permission.model.Role;
import com.antgroup.openspg.app.infra.dao.dataobject.permission.RoleDO;

public class RoleConvertor {

    /**
     * to role
     * @param roleDO
     * @return
     */
    public static Role toRole(RoleDO roleDO) {
        Role role = new Role();
        if (null == roleDO) {
            return role;
        }
        role.setId(roleDO.getId());
        role.setRoleName(roleDO.getRoleName());
        return role;
    }
}
