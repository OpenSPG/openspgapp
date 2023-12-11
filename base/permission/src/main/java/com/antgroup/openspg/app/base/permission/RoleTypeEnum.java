package com.antgroup.openspg.app.base.permission;

/**
 * the kg role type
 */
public enum RoleTypeEnum {

    /**
     * owner of project or resource
     */
    OWNER(2),

    /**
     * project member
     */
    MEMBER(20),

    /**
     * resource read permission
     */
    R_MEMBER(30),

    /**
     * resource write permission
     */
    W_MEMBER(10),

    /**
     * the plaintext permission
     */
    VISIBLE(500);

    int level;
    private RoleTypeEnum(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
