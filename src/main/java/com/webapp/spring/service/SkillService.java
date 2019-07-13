package com.webapp.spring.service;

import com.webapp.spring.model.Skill;

import java.util.List;

public interface SkillService {

    Skill findById(int id);

    List<Skill> findAllSkills();
}
