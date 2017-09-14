package com.rhcloud.tothought.web.spring.converters;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import com.rhcloud.tothought.data.entities.Post;
import com.rhcloud.tothought.data.repositories.PostRepository;

public class StringToPostConverter implements Converter<String, Post> {

	@Autowired
	PostRepository repository;
	
	@Override
	public Post convert(String source) {
		Post post = null;
		if(!StringUtils.isEmpty(source)){
			post = repository.findOne(new Integer(source));
		}
		return post;
	}

}
