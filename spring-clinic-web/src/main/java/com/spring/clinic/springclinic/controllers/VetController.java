package com.spring.clinic.springclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VetController {

	@GetMapping({"/vets","/vets/index"})
	public String listAllVets() {
		return "vets/index";
	}	
}
