package com.spring.clinic.springclinic.controllers;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.clinic.springclinic.model.Vet;
import com.spring.clinic.springclinic.service.VetService;

@Controller
public class VetController {	
	private final VetService vetService;
	
	public VetController(VetService vetService) {
		this.vetService = vetService;
	}

	@GetMapping({"/vets","/vets/index", "/vets.html"})
	public String listAllVets(Model model) {
		Set<Vet> vets = vetService.findAll();
		model.addAttribute("vets", vets);
		
		return "vets/index";
	}	
}
