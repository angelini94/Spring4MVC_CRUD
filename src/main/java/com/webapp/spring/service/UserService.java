package com.webapp.spring.service;

import com.webapp.spring.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {

    User findById(int id);

    void saveUser(User user, MultipartFile image) throws IOException;

    void updateUser(User user, MultipartFile image) throws IOException;

    void deleteUserById(int id);

    List<User> findAllUsers();

    List<User> searchUser(String filterSearch, String inputSearch);
}
