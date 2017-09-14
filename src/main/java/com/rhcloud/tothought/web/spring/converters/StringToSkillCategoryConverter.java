package com.rhcloud.tothought.web.spring.converters;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import com.rhcloud.tothought.data.entities.SkillCategory;
import com.rhcloud.tothought.data.repositories.SkillCategoryRepository;

public class StringToSkillCategoryConverter implements Converter<String, SkillCategory> {

	@Autowired
	SkillCategoryRepository repository;
	
	@Override
	public SkillCategory convert(String source) {
		SkillCategory skillCategory;
		if(StringUtils.isNumeric(source)){
			skillCategory = repository.findOne(new Integer(source));
		}else{
			skillCategory = new SkillCategory();
			skillCategory.setName(source);
		}
		return skillCategory;
	}

}
