package com.spring.clinic.service.mapimpl;

import com.spring.clinic.model.Pet;

public class PetServiceMapImpl extends AbstractMapService<Pet, Long> {

	@Override
	public Pet save(Pet pet) {
		return super.save(pet.getId(), pet);
	}

}
