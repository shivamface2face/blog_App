package com.blogApp.Services;

import com.blogApp.entity.User;
import com.blogApp.paylods.UserDto;

import java.util.List;

public interface UserService {

  UserDto createUser(UserDto user);
  UserDto updateUser(UserDto user,Long id);
  UserDto getUserById(Long id);
  List<UserDto>getAllUser();
  void deleteUser(Long id);

}
