package com.webapp.spring.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.webapp.spring.model.Skill;
import com.webapp.spring.service.SkillService;

/**
 * A converter class used in views to map id's to actual skill objects.
 */
@Component
public class RoleToSkillConverter implements Converter<Object, Skill>{

    @Autowired
    SkillService skillService;

    /**
     * Gets Skill by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public Skill convert(Object element) {
        Integer id = Integer.parseInt((String)element);
        Skill skill= skillService.findById(id);
        System.out.println("Skill : "+skill);
        return skill;
    }

}
