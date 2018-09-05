package com.spring.clinic.springclinic.service.mapimpl;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.spring.clinic.springclinic.model.Pet;
import com.spring.clinic.springclinic.service.PetService;

@Service
public class PetServiceMapImpl extends AbstractMapService<Pet, Long> implements PetService{

	@Override
	public Set<Pet> findAll() {
		return super.findAll();
	}

	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Pet save(Pet object) {
		return super.save(object.getId(), object);
	}

	@Override
	public void delete(Pet object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}
}
