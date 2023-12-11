package com.antgroup.openspg.app.base.permission;

/**
 * the kg permission of project
 */
public interface ProjectPermissionService {

    /**
     * verify the role
     * @param userId
     * @param projectId
     * @return
     */
    Boolean verifyRole(String userId, Long projectId, RoleTypeEnum roleTypeEnum);

    /**
     * add project permission
     * @param token the token of an operator with owner role
     * @param userId
     * @param projectId
     * @param roleTypeEnum
     * @return
     */
    Integer addProjectPermission(String token, String userId, Long projectId, RoleTypeEnum roleTypeEnum) throws Exception;

    /**
     * remove project permission
     * @param token the token of an operator with owner role
     * @param userId
     * @param projectId
     * @return
     */
    Integer removeProjectPermission(String token, String userId, Long projectId) throws Exception;

    /**
     * remove all project permission
     * @param token
     * @param projectId
     * @return
     */
    Integer deleteAllProjectPermission(String token, Long projectId) throws Exception;
}
