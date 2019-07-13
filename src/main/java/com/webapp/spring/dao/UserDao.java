package com.webapp.spring.dao;

import com.webapp.spring.model.User;

import java.util.List;

public interface UserDao {

    User findById(int id);

    void save(User user);

    void deleteById(int id);

    List<User> findAllUsers();

    List<User> searchUser(String filterSearch, String inputSearch);
    
}
