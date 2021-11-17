package com.light.seckill.db.dao;

import com.light.seckill.db.po.User;

public interface UserDao {

    void insertUser(User user);

    void updateUser(User user);

    User queryUser(String userName);


}
