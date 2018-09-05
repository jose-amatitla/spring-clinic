package com.spring.clinic.service;

import java.util.Set;

import com.spring.clinic.model.Pet;

public interface PetService {
	Pet findById(Long id);	
	Pet save(Pet pet);
	Set<Pet> findAll();
}
