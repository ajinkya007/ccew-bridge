package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.dao.UserDao;
import com.test.model.Login;
import com.test.model.User;

public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;

  public void register(User user) {
    userDao.register(user);
  }

  public User validateUser(Login login) {
    return userDao.validateUser(login);
  }

}