package com.antgroup.openspg.app.infra.dao.reposity.permission;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import com.antgroup.openspg.app.base.permission.RoleRepository;
import com.antgroup.openspg.app.base.permission.model.Role;
import com.antgroup.openspg.app.infra.dao.dataobject.permission.RoleDO;
import com.antgroup.openspg.app.infra.dao.mapper.RoleMapper;
import com.antgroup.openspg.app.infra.dao.reposity.permission.convertor.RoleConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> selectAllRoleName() {
        RoleDO roleDO = new RoleDO();
        List<RoleDO> roleDOList = roleMapper.selectByCondition(roleDO, 0, Integer.MAX_VALUE);
        return Optional.ofNullable(roleDOList).orElse(new ArrayList<>()).stream().filter(Objects::nonNull).map(RoleConvertor::toRole).collect(
                Collectors.toList());
    }

    @Override
    public Role selectByRoleName(String roleName) {
        RoleDO roleDO = roleMapper.selectByRoleName(roleName);
        return RoleConvertor.toRole(roleDO);
    }
}
