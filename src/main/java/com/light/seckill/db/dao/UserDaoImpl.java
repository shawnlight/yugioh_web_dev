package com.light.seckill.db.dao;

import com.light.seckill.db.mappers.UserMapper;
import com.light.seckill.db.po.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private UserMapper mapper;

    @Override
    public void insertUser(User user) {
        mapper.insert(user);
    }

    @Override
    public void updateUser(User user) {
        mapper.updateByPrimaryKey(user);
    }

    @Override
    public User queryUser(String userName) {
        return mapper.selectByUserName(userName);
    }





}
