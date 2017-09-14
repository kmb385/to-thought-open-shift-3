package com.rhcloud.tothought.web.spring.listeners;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import com.rhcloud.tothought.data.entities.Image;
import com.rhcloud.tothought.data.repositories.ImageRepository;
import com.rhcloud.tothought.web.spring.utilities.ImageCreatorUtil;

public class ImageLoaderApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

	Logger logger = LoggerFactory.getLogger(ImageLoaderApplicationListener.class);

	@Autowired
	ImageRepository repository;
	
	@Autowired
	ImageCreatorUtil imageCreatorUtil;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		logger.info("Unpacking images from the database.");
		List<Image> images = repository.findAll();

		for (Image image : images) {
			if (!StringUtils.isEmpty(image.getName())) {
				imageCreatorUtil.storeImage(image);
			}
		}
	}
}
