package com.rhcloud.tothought.web.spring.listeners;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import com.rhcloud.tothought.data.entities.SkillCategory;
import com.rhcloud.tothought.data.repositories.SkillCategoryRepository;

public class LookupLoaderApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

	Logger logger = LoggerFactory.getLogger(LookupLoaderApplicationListener.class);

	@Autowired
	SkillCategoryRepository repository;
	
	private List<SkillCategory> categories;
		

	public List<SkillCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<SkillCategory> categories) {
			this.categories = categories;			
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(this.categories == null){
			this.setCategories(repository.findAll());				
		}
	}
}
