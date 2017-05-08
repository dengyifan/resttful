package com.yifan.restful.demo.service.impl;

import com.yifan.restful.demo.dao.UserDao;
import com.yifan.restful.demo.domain.User;
import com.yifan.restful.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yifan on 2017/5/8.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    public List<User> getUserList() {
        List<User> list = userDao.getUserList();
        return list;
    }

    public User getUserById(String userId) {
        return userDao.getUserById(userId);
    }

    public void updateUserEmailById(String userId, String sex) {
        userDao.updateUserEmailById(userId, sex);
    }

    public void deleteUserById(String userId) {
        userDao.deleteUserById(userId);
    }

    public void insertUser(User user) {
        userDao.insertUser(user);
    }
}
