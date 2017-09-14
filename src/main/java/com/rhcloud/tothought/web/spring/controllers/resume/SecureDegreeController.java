package com.rhcloud.tothought.web.spring.controllers.resume;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.rhcloud.tothought.data.entities.Degree;
import com.rhcloud.tothought.data.entities.DegreeDetail;
import com.rhcloud.tothought.data.repositories.DegreeDetailRepository;
import com.rhcloud.tothought.data.repositories.DegreeRepository;
import com.rhcloud.tothought.data.validators.DegreeValidator;

@Controller
@RequestMapping("/secure/resume/manager/degree")
public class SecureDegreeController {

	@Autowired
	DegreeRepository repository;
	
	@Autowired
	DegreeDetailRepository detailRepository;
	
	
	@RequestMapping("/")
	public String getDegrees(){
		return "degrees";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/new")
	public String createDegree(Model model){
		model.addAttribute("degree", new Degree());
		return "/resume/manager/manageDegree";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/edit/{degreeId}")
	public String editDegree(@PathVariable Integer degreeId, Model model){
		model.addAttribute("degree", repository.findOne(degreeId));
		return "/resume/manager/manageDegree";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/save")
	public String saveDegree(@Valid @ModelAttribute Degree degree, BindingResult result){
		if(result.hasErrors()){
			return "/resume/manager/manageDegree";
		}
		repository.save(degree);
		return "redirect:/resume/degree";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/{detailId}/deletedetail")
	public String deleteDetail(@PathVariable("detailId") Integer detailId, Model model){
		DegreeDetail degreeDetail = detailRepository.findOne(detailId);
		Degree degree = degreeDetail.getDegree();
		
		List<DegreeDetail> details = degree.getDegreeDetails();
		details.remove(degreeDetail);
		repository.save(degree);
		
		return "redirect:/secure/resume/manager/degree/edit/" + degree.getDegreeId().toString();
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/delete/{degreeId}")
	public String deleteDegree(@PathVariable Integer degreeId){
		repository.delete(degreeId);
		return "redirect:/resume/degree";
	}

	/**
	 * Sets a binder to handle the conversion of the file.
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinderAll(WebDataBinder binder) {
		   SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		   dateFormat.setLenient(false);

		// true passed to CustomDateEditor constructor means convert empty String to null
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.setValidator(new DegreeValidator());
	}

}
