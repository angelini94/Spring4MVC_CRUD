package com.webapp.spring.dao;

import com.webapp.spring.model.Status;

import java.util.List;

public interface StatusDao {

    Status findById(int id);

    List<Status> findAllStatus();
}
