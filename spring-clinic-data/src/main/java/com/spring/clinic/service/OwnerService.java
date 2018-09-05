package com.spring.clinic.service;

import java.util.Set;

import com.spring.clinic.model.Owner;

public interface OwnerService {
	Owner findById(Long id);
	Owner findByLastName(String lastName);
	Owner save(Owner owner);
	Set<Owner> findAll();
}
