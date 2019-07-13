package com.webapp.spring.dao;

import com.webapp.spring.model.User;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User>implements UserDao {

    public User findById(int id) {
        User user = getByKey(id);
        if (user!=null){
            initializeCollection(user.getSkills());
        }
        return user;
    }

    public void save(User user){
        persist(user);
    }

    public void deleteById(int id){
        User user = getByKey(id);
        delete(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        List<User> users = getEntityManager()
                .createQuery("SELECT u FROM User u")
                .getResultList();
        for (User user : users){
            Hibernate.initialize(user.getSkills());
            Hibernate.initialize(user.getRole());
            Hibernate.initialize(user.getStatus());
        }
        return users;
    }

    public List<User> searchUser(String filterSearch, String inputSearch) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();

        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> user = query.from(User.class);
        if (!filterSearch.isEmpty()){
                query.select(user).where(cb.equal(user.get(filterSearch), inputSearch));
        }
        TypedQuery<User> userTypedQuery = getEntityManager().createQuery(query);
        List<User> users = userTypedQuery.getResultList();
        return users;
    }


    protected void initializeCollection(Collection<?> collection) {
        if (collection == null){
            return;
        }
        collection.iterator().hasNext();
    }
}
