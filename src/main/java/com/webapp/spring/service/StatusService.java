package com.webapp.spring.service;

import com.webapp.spring.model.Status;

import java.util.List;

public interface StatusService {

    Status findById(int id);

    List<Status> findAllStatus();
}
