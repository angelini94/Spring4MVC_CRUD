package com.webapp.spring.converter;

import com.webapp.spring.model.Status;
import com.webapp.spring.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StatusConverter implements Converter<Object, Status> {

    @Autowired
    StatusService statusService;

    public Status convert(Object element){
        Integer id = Integer.parseInt((String)element);
        Status status = statusService.findById(id);
        System.out.println("Status :" +status);
        return status;
    }
}
