package com.test.dao;


import com.test.model.Login;
import com.test.model.User;
public interface UserDao {
  void register(User user);
  User validateUser(Login login);
}
