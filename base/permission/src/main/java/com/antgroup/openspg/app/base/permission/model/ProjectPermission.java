package com.antgroup.openspg.app.base.permission.model;

import java.io.Serializable;
import java.util.Date;

/**
 * the permission of the project
 */
public class ProjectPermission implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * the role id
     */
    private Long roleId;

    /**
     * projectId
     */
    private Long projectId;

    /**
     * userId
     */
    private String userNo;

    /**
     * DELETE VALID INVALID
     */
    private String status;

    /**
     * create time
     */
    private Date gmtCreate;

    /**
     * modified time
     */
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
