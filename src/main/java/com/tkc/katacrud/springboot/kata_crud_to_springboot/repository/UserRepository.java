package com.tkc.katacrud.springboot.kata_crud_to_springboot.repository;


import com.tkc.katacrud.springboot.kata_crud_to_springboot.entity.User;

import java.util.List;

public interface UserRepository {
   public void saveUser(User user);
   public List<User> getAllUsers();
   public User getUser(int id);
   public void deleteUser(User user);
}
