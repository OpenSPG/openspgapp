package com.antgroup.openspg.app.base.permission.impl;

import java.util.List;

import com.antgroup.openspg.app.base.account.AccountRepository;
import com.antgroup.openspg.app.base.account.model.User;
import com.antgroup.openspg.app.base.permission.ProjectPermissionRepository;
import com.antgroup.openspg.app.base.permission.ProjectPermissionService;
import com.antgroup.openspg.app.base.permission.RoleRepository;
import com.antgroup.openspg.app.base.permission.RoleTypeEnum;
import com.antgroup.openspg.app.base.permission.model.ProjectPermission;
import com.antgroup.openspg.app.base.permission.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class ProjectPermissionServiceImpl implements ProjectPermissionService {

    @Autowired
    private ProjectPermissionRepository projectPermissionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Boolean verifyRole(String userId, Long projectId, RoleTypeEnum roleTypeEnum) {
        ProjectPermission projectPermission = new ProjectPermission();
        projectPermission.setUserNo(userId);
        projectPermission.setProjectId(projectId);
        List<ProjectPermission> projectPermissionList = projectPermissionRepository.queryByCondition(projectPermission);
        if (CollectionUtils.isEmpty(projectPermissionList)) {
            return false;
        }
        Role role = roleRepository.selectByRoleName(roleTypeEnum.name());
        return projectPermissionList.get(0).getRoleId().equals(role.getId());
    }

    @Override
    public Integer addProjectPermission(String token, String userId, Long projectId, RoleTypeEnum roleTypeEnum)  throws Exception {
        checkOwner(token, projectId);
        ProjectPermission projectPermission = new ProjectPermission();
        projectPermission.setProjectId(projectId);
        projectPermission.setUserNo(userId);
        Role role = roleRepository.selectByRoleName(roleTypeEnum.name());
        projectPermission.setRoleId(role.getId());
        projectPermission.setStatus("VALID");
        int count = projectPermissionRepository.upsert(projectPermission);
        return count;
    }

    @Override
    public Integer removeProjectPermission(String token, String userId, Long projectId)  throws Exception {
        checkOwner(token, projectId);
        return projectPermissionRepository.removeProjectPermission(userId, projectId);
    }

    @Override
    public Integer deleteAllProjectPermission(String token, Long projectId)  throws Exception {
        checkOwner(token, projectId);
        return projectPermissionRepository.removeAllProjectPermission(projectId);
    }

    private void checkOwner(String token, Long projectId) throws Exception {
        User user = accountRepository.queryByToken(token);
        if (null == user) {
            throw new Exception("invalid user");
        }

        Boolean isOwner = verifyRole(user.getWorkNo(), projectId, RoleTypeEnum.OWNER);
        if (!isOwner) {
            throw new Exception("need the project owner");
        }
    }

}
