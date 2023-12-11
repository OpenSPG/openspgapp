package com.antgroup.openspg.app.infra.dao.reposity.permission.convertor;

import com.antgroup.openspg.app.base.permission.model.SchemaPermission;
import com.antgroup.openspg.app.infra.dao.dataobject.permission.UserResourceRoleDO;

public class SchemaPermissionConvertor {

    /**
     * to db resourceRole object
     * @param schemaPermission
     * @return
     */
    public static UserResourceRoleDO toUserResourceRoleDO(SchemaPermission schemaPermission) {
        UserResourceRoleDO resourceRoleDO = new UserResourceRoleDO();
        if (null == schemaPermission) {
            return resourceRoleDO;
        }
        resourceRoleDO.setId(schemaPermission.getId());
        resourceRoleDO.setResourceId(schemaPermission.getResourceId());
        resourceRoleDO.setRoleId(schemaPermission.getRoleId());
        resourceRoleDO.setUserNo(schemaPermission.getUserNo());
        resourceRoleDO.setStatus(schemaPermission.getStatus());
        resourceRoleDO.setResourceTag(schemaPermission.getResourceTag());
        return resourceRoleDO;
    }

    /**
     * to resourceRole
     * @param userResourceRoleDO
     * @return
     */
    public static SchemaPermission toSchemaPermission(UserResourceRoleDO userResourceRoleDO) {
        SchemaPermission schemaPermission = new SchemaPermission();
        if (null == userResourceRoleDO) {
            return schemaPermission;
        }
        schemaPermission.setId(userResourceRoleDO.getId());
        schemaPermission.setRoleId(userResourceRoleDO.getRoleId());
        schemaPermission.setResourceTag(userResourceRoleDO.getResourceTag());
        schemaPermission.setStatus(userResourceRoleDO.getStatus());
        schemaPermission.setResourceId(userResourceRoleDO.getResourceId());
        schemaPermission.setUserNo(userResourceRoleDO.getUserNo());
        return schemaPermission;
    }
}
