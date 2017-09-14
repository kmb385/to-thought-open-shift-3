package com.rhcloud.tothought.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rhcloud.tothought.data.entities.SkillCategory;

public interface SkillCategoryRepository extends JpaRepository<SkillCategory, Integer> {

}
