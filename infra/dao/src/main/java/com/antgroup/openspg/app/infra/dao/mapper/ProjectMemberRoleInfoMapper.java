/**
 *   * Alipay.com Inc.  * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.antgroup.openspg.app.infra.dao.mapper;

import java.util.List;

import com.antgroup.openspg.app.infra.dao.dataobject.permission.ProjectMemberRoleInfoDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProjectMemberRoleInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kg_project_member_role_info
     *
     * @param record com.alipay.kgmng.common.dal.mybatis.po.KgProjectMemberRoleInfoPO
     * @return int
     */
    int insert(ProjectMemberRoleInfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kg_project_member_role_info
     *
     * @param id java.lang.Long
     * @return int
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kg_project_member_role_info
     *
     * @param ids List<Long>
     * @return int
     */
    int deleteByIds(@Param("ids") List<Long> ids);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kg_project_member_role_info
     *
     * @param record com.alipay.kgmng.common.dal.mybatis.po.KgProjectMemberRoleInfoPO
     * @return int
     */
    int updateByPrimaryKeySelective(ProjectMemberRoleInfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kg_project_member_role_info
     *
     * @param id java.lang.Long
     * @return com.alipay.kgmng.common.dal.mybatis.po.KgProjectMemberRoleInfoPO
     */
    ProjectMemberRoleInfoDO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kg_project_member_role_info
     *
     * @param record com.alipay.kgmng.common.dal.mybatis.po.KgProjectMemberRoleInfoPO
     * @param start int
     * @param size int
     * @return List<KgProjectMemberRoleInfoPO>
     */
    List<ProjectMemberRoleInfoDO> selectByCondition(@Param("record") ProjectMemberRoleInfoDO record, @Param("start") int start,
                                                    @Param("size") int size);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kg_project_member_role_info
     *
     * @param record com.alipay.kgmng.common.dal.mybatis.po.KgProjectMemberRoleInfoPO
     * @return int
     */
    int selectCountByCondition(ProjectMemberRoleInfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kg_project_member_role_info
     *
     * @param ids List<Long>
     * @return List<KgProjectMemberRoleInfoPO>
     */
    List<ProjectMemberRoleInfoDO> selectByIds(@Param("ids") List<Long> ids);

    /**
     * 删除项目成员
     * @param projectId
     * @return
     */
    int deleteByProjectId(@Param("projectId") long projectId);

    int deleteByProjectIdAndUserId(@Param("userNo") String userNo, @Param("projectId") long projectId);

    /**
     * 批量添加
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<ProjectMemberRoleInfoDO> records);

    /**
     * 查询所有符合条件的角色
     * @param kgProjectMemberRoleInfoDO
     * @return
     */
    List<ProjectMemberRoleInfoDO> selectAllByCondition(@Param("record") ProjectMemberRoleInfoDO kgProjectMemberRoleInfoDO);

    /**
     * 查询用户下所有的项目权限
     * @param userNo
     * @return
     */
    List<ProjectMemberRoleInfoDO> selectByUserNo(@Param("userNo") String userNo);

    int updateByProjectId(ProjectMemberRoleInfoDO record);

    List<ProjectMemberRoleInfoDO> selectForUpdate();

    List<ProjectMemberRoleInfoDO> selectMemberWithFilter(@Param("projectId") long projectId, @Param("filter") String filter,
                                                         @Param("start") int start, @Param("size") int size, @Param("roleId") Long roleId);

    int selectMemberCountWithFilter(@Param("projectId") long projectId, @Param("filter") String filter, @Param("roleId") Long roleId);

    List<ProjectMemberRoleInfoDO> selectByProjectIdAndUserNo(@Param("projectId") long projectId, @Param("userNo") String userNo);

    /**
     * 根据项目id和工号更新项目成员信息
     * @param record
     * @return
     */
    int updateByProjectAndUserNo(@Param("record") ProjectMemberRoleInfoDO record);
}