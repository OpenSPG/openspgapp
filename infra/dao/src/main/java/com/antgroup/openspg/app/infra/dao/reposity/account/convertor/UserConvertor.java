package com.antgroup.openspg.app.infra.dao.reposity.account.convertor;

import com.antgroup.openspg.app.base.account.model.User;
import com.antgroup.openspg.app.infra.dao.dataobject.account.UserDO;

public class UserConvertor {

    /**
     * to user
     * @param userDO
     * @return
     */
    public static User toUser(UserDO userDO) {
        User user = new User();
        if (null == userDO) {
            return user;
        }
        user.setId(userDO.getId());
        user.setWorkNo(userDO.getUserNo());
        user.setNickName(userDO.getNickName());
        user.setRealName(userDO.getRealName());
        user.setLoginAccount(userDO.getDomainAccount());
        user.setEmail(userDO.getEmail());
        user.setMobile(userDO.getMobile());
        user.setToken(userDO.getToken());
        return user;
    }

    /**
     * to db user object
     * @param user
     * @return
     */
    public static UserDO toUserDO(User user) {
        UserDO userDO = new UserDO();
        if (null == user) {
            return userDO;
        }
        userDO.setId(user.getId());
        userDO.setNickName(user.getNickName());
        userDO.setRealName(user.getRealName());
        userDO.setDomainAccount(user.getLoginAccount());
        userDO.setToken(user.getToken());
        userDO.setEmail(user.getEmail());
        userDO.setUserNo(user.getWorkNo());
        return userDO;
    }
}
