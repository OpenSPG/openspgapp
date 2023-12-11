package com.antgroup.openspg.app.base.account;

import java.util.List;

import com.antgroup.openspg.app.base.account.model.User;

public interface AccountRepository {

    /**
     * insert or update user
     * @param user
     * @return
     */
    Integer upsert(User user);

    /**
     * query by fuzzy keyword
     * @param keyword  userNo or domainNo or name
     * @return
     */
    List<User> queryLike(String keyword);

    /**
     * query user by token
     * @param token
     * @return
     */
    User queryByToken(String token);
}
