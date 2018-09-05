package com.spring.clinic.springclinic.controllers;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.clinic.springclinic.model.Owner;
import com.spring.clinic.springclinic.service.OwnerService;

@Controller
public class OwnerController {	
	private final OwnerService ownerService;
	
	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}	
	
	@GetMapping({"/owners","/owners/index"})
	public String listOwners(Model model) {
		Set<Owner> owners = ownerService.findAll();
		model.addAttribute("owners", owners);
		
		return "owners/index";
	}
}
