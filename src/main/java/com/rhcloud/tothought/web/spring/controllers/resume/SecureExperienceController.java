package com.rhcloud.tothought.web.spring.controllers.resume;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.rhcloud.tothought.data.entities.Experience;
import com.rhcloud.tothought.data.entities.ExperienceDetail;
import com.rhcloud.tothought.data.repositories.ExperienceDetailRepository;
import com.rhcloud.tothought.data.repositories.ExperienceRepository;
import com.rhcloud.tothought.data.validators.ExperienceValidator;
import com.rhcloud.tothought.web.spring.utilities.TagCreatorUtil;

@Controller
@RequestMapping("/secure/resume/manager/experience")
public class SecureExperienceController {
	
	@Autowired
	ExperienceRepository experienceRepository;
	
	@Autowired
	ExperienceDetailRepository detailRepository;
	
	@Autowired
	TagCreatorUtil tagCreatorUtil;
	
	@RequestMapping("/")
	public String getExperiences(){		
		return "resume/experience";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping("/new")
	public String newExperience(Model model){
		model.addAttribute("experience", new Experience());
		return "resume/manager/manageExperience";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping("/edit/{experienceId}")
	public String editExperience(@PathVariable Integer experienceId, Model model){
		model.addAttribute("experience", experienceRepository.findOne(experienceId));
		return "resume/manager/manageExperience";		
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping("/save")
	public String save(@Valid @ModelAttribute Experience experience, BindingResult result, @RequestParam("tags") String tags){
		
		if(result.hasErrors()){
			return "resume/manager/manageExperience";
		}
		
		experience.setTags(tagCreatorUtil.createTags(tags));
		experienceRepository.save(experience);
		return "redirect:/resume/experience";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping("/delete/{experienceId}")
	public String deleteExperience(@PathVariable Integer experienceId){
		experienceRepository.delete(experienceId);
		return "redirect:/resume/experience";		
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping("/{detailId}/deleteexperience")
	public String deleteExperienceDetail(@PathVariable("detailId") Integer detailId, Model model){
		ExperienceDetail experienceDetail = detailRepository.findOne(detailId);
		Experience experience = experienceDetail.getExperience();
		
		List<ExperienceDetail> details = experience.getExperienceDetails();
		details.remove(details.indexOf(experienceDetail));
		experienceRepository.save(experience);
		
		return "redirect:/secure/resume/manager/experience/edit/" + experience.getExperienceId().toString();
	}

	/**
	 * Sets a binder to handle the conversion of the file.
	 * 
	 * @param binder
	 */
	@InitBinder("experience")
	public void initBinderAll(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateFormat.setLenient(false);

		// true passed to CustomDateEditor constructor means convert empty
		// String to null, prevents error when date is null
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.setValidator(new ExperienceValidator());
	}

}
