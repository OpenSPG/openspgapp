package com.antgroup.openspg.app.base.permission;

import java.util.List;

/**
 * the permission of the schema
 */
public interface SchemaPermissionService {

    /**
     * verify the role
     * @param userId
     * @param resourceId
     * @param resourceTypeEnum
     * @param roleTypeEnum
     * @return
     */
    Boolean verifyRole(String userId, Long resourceId, ResourceTypeEnum resourceTypeEnum, RoleTypeEnum roleTypeEnum);

    /**
     * grant role
     * @param token
     * @param userIds
     * @param resourceIds
     * @param resourceTypeEnum
     * @param roleTypeEnum
     * @return
     */
    Integer addResourceRole(String token, List<String> userIds, List<Long> resourceIds, ResourceTypeEnum resourceTypeEnum, RoleTypeEnum roleTypeEnum) throws Exception;

    /**
     * remove the role
     * @param token
     * @param userIds
     * @param resourceIds
     * @return
     */
    Integer removeRole(String token, List<Long> userIds, List<Long> resourceIds, ResourceTypeEnum resourceTypeEnum) throws Exception;
}
