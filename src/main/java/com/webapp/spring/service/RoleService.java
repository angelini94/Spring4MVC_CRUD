package com.webapp.spring.service;

import com.webapp.spring.model.Role;

import java.util.List;

public interface RoleService {

    Role findById(int id);

    List<Role> findAllRoles();
}
