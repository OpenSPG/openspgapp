package com.antgroup.openspg.app.infra.dao.reposity.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import com.antgroup.openspg.app.base.account.AccountRepository;
import com.antgroup.openspg.app.base.account.model.User;
import com.antgroup.openspg.app.infra.dao.dataobject.account.UserDO;
import com.antgroup.openspg.app.infra.dao.mapper.UserMapper;
import com.antgroup.openspg.app.infra.dao.reposity.account.convertor.UserConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer upsert(User user) {
        UserDO userDO = UserConvertor.toUserDO(user);
        userDO.setGmtModified(new Date());
        int count;
        if (null == userDO.getId()) {
            userDO.setGmtCreate(new Date());
            count = userMapper.insert(userDO);
        } else {
            count = userMapper.updateByPrimaryKeySelective(userDO);
        }
        return count;
    }

    @Override
    public List<User> queryLike(String keyword) {
        List<UserDO> userDOList = userMapper.getUserLikeUserNoOrDomainNoOrName(keyword);
        return Optional.ofNullable(userDOList).orElse(new ArrayList<>()).stream().filter(Objects::nonNull).map(UserConvertor::toUser).collect(
                Collectors.toList());
    }

    @Override
    public User queryByToken(String token) {
        UserDO userDO = new UserDO();
        userDO.setToken(token);
        List<UserDO> userDOList = userMapper.selectByCondition(userDO, 0, 1);
        return Optional.ofNullable(userDOList).orElse(new ArrayList<>()).stream().filter(Objects::nonNull).map(UserConvertor::toUser).collect(
                Collectors.toList()).get(0);
    }
}
