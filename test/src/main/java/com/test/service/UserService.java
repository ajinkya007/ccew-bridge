package com.test.service;
import com.test.model.Login;
import com.test.model.User;

public interface UserService {

  void register(User user);

  User validateUser(Login login);
}
