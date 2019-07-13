package com.webapp.spring.dao;

import com.webapp.spring.model.Status;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository("statusDao")
public class StatusDaoImpl extends AbstractDao<Integer, Status> implements StatusDao {

    public Status findById(int id){
        Status status = getByKey(id);
        return status;
    }

    @SuppressWarnings("unchecked")
    public List<Status> findAllStatus(){
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();

        CriteriaQuery<Status> query = cb.createQuery(Status.class);
        Root<Status> status = query.from(Status.class);

        TypedQuery<Status> statusTypedQuery = getEntityManager().createQuery(query.select(status));
        List<Status> statuses = statusTypedQuery.getResultList();
        return statuses;
    }
}
