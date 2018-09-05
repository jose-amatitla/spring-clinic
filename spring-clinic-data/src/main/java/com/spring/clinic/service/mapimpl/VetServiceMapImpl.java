package com.spring.clinic.service.mapimpl;

import com.spring.clinic.model.Vet;

public class VetServiceMapImpl extends AbstractMapService<Vet, Long> {

	@Override
	public Vet save(Vet vet) {
		return super.save(vet.getId(), vet);
	}

}
