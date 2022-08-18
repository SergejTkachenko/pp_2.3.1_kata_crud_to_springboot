package com.tkc.katacrud.springboot.kata_crud_to_springboot.service;


import com.tkc.katacrud.springboot.kata_crud_to_springboot.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    List<User> getAllUsers();
    public User getUser(int id);
    public void deleteUser(User user);
}
