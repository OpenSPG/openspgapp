package com.antgroup.openspg.app.base.account;

import com.antgroup.openspg.app.base.account.model.User;

import java.util.List;

/**
 * account service
 */
public interface AccountService {

  /**
   * get user info by work number
   *
   * @param workNo
   * @return
   */
  User getUserInfoByWorkNo(String workNo);

  /**
   * get user info by domain account
   * @param account the out user no
   * @return the get user info by out user no
   */
  User getUserInfoByLoginAccount(String account) throws Exception;

  /**
   * get match by fuzzy keyword
   *
   * @param keyword name、nickname、the pinyin of name
   */
  List<User> getUserInfoListByKeyword(String keyword) throws Exception;

  /**
   * get the login user
   */
  User getLoginUser();

  /**
   * the login user is super manager
   *
   * @return
   */
  Boolean haveSuperPermission();

  /**
   * logout
   *
   * @param redirectUrl
   */
  String logout(String redirectUrl);
}
