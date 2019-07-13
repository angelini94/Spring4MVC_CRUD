package com.webapp.spring.dao;

import com.webapp.spring.model.Role;

import java.util.List;

public interface RoleDao {

    Role findById(int id);

    List<Role> findAllRoles();
}
