package com.rhcloud.tothought.web.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.rhcloud.tothought.data.repositories.TagRepository;
import com.rhcloud.tothought.web.json.JsonUtil;

@Controller
@RequestMapping("/tag")
public class TagController {

	@Autowired
	TagRepository repository;
	
	@RequestMapping("/")
	public String getTagSample(){
		return "fragments/tag_editor_sandbox";
	}

	@RequestMapping("/find/{tagNamePart}")
	@ResponseBody
	public String getTagsByTagNamePart(@PathVariable String tagNamePart){
		return JsonUtil.getJson(repository.findByName(tagNamePart));
	}
}
