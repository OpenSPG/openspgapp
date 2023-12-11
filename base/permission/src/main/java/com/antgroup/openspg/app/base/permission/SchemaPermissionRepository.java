package com.antgroup.openspg.app.base.permission;

import java.util.List;

import com.antgroup.openspg.app.base.permission.model.SchemaPermission;

public interface SchemaPermissionRepository {

    /**
     * add or update schemaPermission
     * @param schemaPermission
     * @return
     */
    int upsert(SchemaPermission schemaPermission);

    /**
     * batch insert schemaPermission
     * @param schemaPermissionList
     * @return
     */
    int batchInsert(List<SchemaPermission> schemaPermissionList);

    /**
     * delete schemaPermission by id
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * batch remove schemaPermission
     * @param userIds
     * @param resourceIds
     * @param resourceTypeEnum
     * @return
     */
    int batchRemove(List<Long> userIds, List<Long> resourceIds, ResourceTypeEnum resourceTypeEnum);

    /**
     * query schemaPermission by conditions
     * @param schemaPermission
     * @return
     */
    List<SchemaPermission> queryByCondition(SchemaPermission schemaPermission);

    /**
     * batch query by resourceIds
     * @param resourceIds
     * @param resourceTypeEnum
     * @return
     */
    List<SchemaPermission> queryByResourceIds(List<Long> resourceIds, ResourceTypeEnum resourceTypeEnum);
}
