package com.antgroup.openspg.app.base.permission;

import java.util.List;

import com.antgroup.openspg.app.base.permission.model.ProjectPermission;

/**
 * The repository service for projectPermission
 */
public interface ProjectPermissionRepository {

    /**
     * add or update projectPermission
     * @param projectPermission
     * @return
     */
    int upsert(ProjectPermission projectPermission);

    /**
     * delete projectPermission by id
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * remove the userId
     * @param userId
     * @param projectId
     * @return
     */
    int removeProjectPermission(String userId, Long projectId);

    /**
     * remove all permission for the project
     * @param projectId
     * @return
     */
    int removeAllProjectPermission(Long projectId);

    /**
     * query projectPermission by conditions
     * @param projectPermission
     * @return
     */
    List<ProjectPermission> queryByCondition(ProjectPermission projectPermission);

}
