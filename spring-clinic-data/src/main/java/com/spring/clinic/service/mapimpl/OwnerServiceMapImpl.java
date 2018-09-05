package com.spring.clinic.service.mapimpl;

import com.spring.clinic.model.Owner;

public class OwnerServiceMapImpl extends AbstractMapService<Owner, Long> {
	
	@Override
	public Owner save(Owner owner) {
		return super.save(owner.getId(), owner);
	}
}
