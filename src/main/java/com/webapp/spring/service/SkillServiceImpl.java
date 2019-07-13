package com.webapp.spring.service;

import com.webapp.spring.dao.SkillDao;
import com.webapp.spring.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("skillService")
@Transactional
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillDao skillDao;

    public Skill findById(int id) {
        return skillDao.findById(id);
    }

    public List<Skill> findAllSkills() {
        return skillDao.findAllSkills();
    }
}