package com.spring.clinic.springclinic.service.jpaimpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.spring.clinic.springclinic.model.Pet;
import com.spring.clinic.springclinic.repository.PetRepository;
import com.spring.clinic.springclinic.service.PetService;

@Service
@Profile("jpa")
public class PetServiceJPAImpl implements PetService {
	
	private final PetRepository petRepository;
	
	public PetServiceJPAImpl(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	@Override
	public Pet findById(Long id) {		
		return petRepository.findById(id).orElse(null);
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<>();
		petRepository.findAll().forEach(pets::add);
		
		return null;
	}

	@Override
	public Pet save(Pet object) {
		return petRepository.save(object);
	}

	@Override
	public void delete(Pet object) {
		petRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id)
	}

}
