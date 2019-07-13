package com.webapp.spring.converter;

import com.webapp.spring.model.Role;
import com.webapp.spring.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter implements Converter<Object, Role> {

    @Autowired
    RoleService roleService;

    //Gets Role by Id
    public Role convert(Object element){
        Integer id = Integer.parseInt((String)element);
        Role role = roleService.findById(id);
        System.out.println("Role :" +role);
        return role;
    }
}
