package com.webapp.spring.dao;

import com.webapp.spring.model.Skill;

import java.util.List;

public interface SkillDao {

    Skill findById(int id);

    List<Skill> findAllSkills();
}
