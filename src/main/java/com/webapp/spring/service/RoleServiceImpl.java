package com.webapp.spring.service;

import com.webapp.spring.dao.RoleDao;
import com.webapp.spring.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role findById(int id) {
        return roleDao.findById(id);
    }

    public List<Role> findAllRoles() {
        return roleDao.findAllRoles();
    }
}
