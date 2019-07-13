package com.webapp.spring.service;

import com.webapp.spring.dao.UserDao;
import com.webapp.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    public User findById(int id){
        return userDao.findById(id);
    }

    public void saveUser(User user, MultipartFile image) throws IOException {
        saveImage(user, image);
        userDao.save(user);
    }

    public void updateUser(User user, MultipartFile image) throws IOException {
        User entity = userDao.findById(user.getId());
        saveImage(user, image);
        if (entity!=null){
            entity.setFirstname(user.getFirstname());
            entity.setLastname(user.getLastname());
            entity.setCountry(user.getCountry());
            entity.setBirthdate(user.getBirthdate());
            entity.setRole(user.getRole());
            entity.setStatus(user.getStatus());
            entity.setSkills(user.getSkills());
            entity.setFileName(user.getFileName());


        }
    }

    public void saveImage(User user, MultipartFile multipartFile) throws IOException {
        if (!multipartFile.isEmpty()) {
            String filename = multipartFile.getOriginalFilename();
            FileCopyUtils.copy(multipartFile.getBytes(), new File("C:/mytemp/" + filename));

            user.setFileName(filename);

        }
    }

    public void deleteUserById(int id){
        userDao.deleteById(id);
    }

    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    public List<User> searchUser(String filterSearch, String inputSearch) {
        return userDao.searchUser(filterSearch, inputSearch);
    }
}
