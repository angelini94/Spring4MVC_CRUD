package com.webapp.spring.dao;

import com.webapp.spring.model.Skill;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

    @Repository("skillDao")
    public class SkillDaoImpl extends AbstractDao<Integer, Skill> implements SkillDao {

        public Skill findById(int id){
            Skill skill = getByKey(id);
            return skill;
        }

        @SuppressWarnings("unchecked")
        public List<Skill> findAllSkills(){
            CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();

            CriteriaQuery<Skill> query = cb.createQuery(Skill.class);
            Root<Skill> skill = query.from(Skill.class);

            TypedQuery<Skill> skillTypedQuery = getEntityManager().createQuery(query.select(skill));
            List<Skill> skills = skillTypedQuery.getResultList();
            return skills;
        }
}
