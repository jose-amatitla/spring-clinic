package com.spring.clinic.springclinic.service.jpaimpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.spring.clinic.springclinic.model.PetType;
import com.spring.clinic.springclinic.repository.PetTypeRepository;
import com.spring.clinic.springclinic.service.PetTypeService;

@Service
@Profile("jpa")
public class PetTypeServiceJPAImpl implements PetTypeService {

	private final PetTypeRepository petTypeRepository;
	
	public PetTypeServiceJPAImpl(PetTypeRepository petTypeRepository) {
		this.petTypeRepository = petTypeRepository;
	}
	
	@Override
	public PetType findById(Long id) {
		return petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypes = new HashSet<>();
		petTypeRepository.findAll().forEach(petTypes::add);
		
		return petTypes;
	}

	@Override
	public PetType save(PetType object) {
		return petTypeRepository.save(object);
	}

	@Override
	public void delete(PetType object) {
		petTypeRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		petTypeRepository.deleteById(id);
	}
}
