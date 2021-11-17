package com.light.seckill.service;


import com.light.seckill.db.dao.UserDao;
import com.light.seckill.db.po.User;
import com.light.seckill.security.UserDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class UserService implements UserDetailsService {

    @Resource
    UserDao userDao;


    public boolean isUserExist(String userName) {
        User user = userDao.queryUser(userName);
        if(user == null){
            log.error("user name already exist");
            return false;
        }
        return true;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.queryUser(email);
        if(user == null){
            throw new UsernameNotFoundException("user name not found");
        }

        return new UserDetail(user);
    }
}
