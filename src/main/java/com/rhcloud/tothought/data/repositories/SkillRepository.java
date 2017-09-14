package com.rhcloud.tothought.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rhcloud.tothought.data.entities.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

}
