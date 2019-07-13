package com.webapp.spring.service;

import com.webapp.spring.dao.StatusDao;
import com.webapp.spring.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("statusService")
@Transactional
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusDao statusDao;

    public Status findById(int id) {
        return statusDao.findById(id);
    }

    public List<Status> findAllStatus() {
        return statusDao.findAllStatus();
    }
}
