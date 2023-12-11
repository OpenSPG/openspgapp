package com.antgroup.openspg.app.infra.dao.reposity.permission;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import com.antgroup.openspg.app.base.permission.ProjectPermissionRepository;
import com.antgroup.openspg.app.base.permission.model.ProjectPermission;
import com.antgroup.openspg.app.infra.dao.dataobject.permission.ProjectMemberRoleInfoDO;
import com.antgroup.openspg.app.infra.dao.mapper.ProjectMemberRoleInfoMapper;
import com.antgroup.openspg.app.infra.dao.reposity.permission.convertor.ProjectPermissionConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectPermissionRepositoryImpl implements ProjectPermissionRepository {

    @Autowired
    private ProjectMemberRoleInfoMapper kgProjectMemberRoleInfoMapper;

    @Override
    public int upsert(ProjectPermission projectPermission) {
        int count;
        ProjectMemberRoleInfoDO roleInfoDO = ProjectPermissionConvertor.toProjectPermissionDO(projectPermission);
        if (null == roleInfoDO.getId()) {
            roleInfoDO.setGmtCreate(new Date());
            roleInfoDO.setGmtModified(new Date());
            count = kgProjectMemberRoleInfoMapper.insert(roleInfoDO);
        } else {
            roleInfoDO.setGmtModified(new Date());
            count = kgProjectMemberRoleInfoMapper.updateByPrimaryKeySelective(roleInfoDO);
        }
        return count;
    }

    @Override
    public int deleteById(Long id) {
        return kgProjectMemberRoleInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int removeProjectPermission(String userId, Long projectId) {
        return kgProjectMemberRoleInfoMapper.deleteByProjectIdAndUserId(userId, projectId);
    }

    @Override
    public int removeAllProjectPermission(Long projectId) {
        return kgProjectMemberRoleInfoMapper.deleteByProjectId(projectId);
    }

    @Override
    public List<ProjectPermission> queryByCondition(ProjectPermission projectPermission) {
        ProjectMemberRoleInfoDO roleInfoDO = ProjectPermissionConvertor.toProjectPermissionDO(projectPermission);
        List<ProjectMemberRoleInfoDO> roleInfoDOList = kgProjectMemberRoleInfoMapper.selectAllByCondition(roleInfoDO);
        return Optional.ofNullable(roleInfoDOList).orElse(new ArrayList<>()).stream().map(ProjectPermissionConvertor::toProjectPermission).filter(Objects::nonNull).collect(Collectors.toList());
    }
}
