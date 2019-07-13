package com.webapp.spring.dao;

import com.webapp.spring.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Integer, Role> implements RoleDao {

    public Role findById(int id){
        Role role = getByKey(id);
        return role;
    }

    @SuppressWarnings("unchecked")
    public List<Role> findAllRoles(){

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();

        CriteriaQuery<Role> query = cb.createQuery(Role.class);
        Root<Role> role = query.from(Role.class);

        TypedQuery<Role> roleTypedQuery = getEntityManager().createQuery(query.select(role));
        List<Role> roles = roleTypedQuery.getResultList();

        return roles;
    }
}
