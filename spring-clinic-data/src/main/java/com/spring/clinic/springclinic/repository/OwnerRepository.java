package com.spring.clinic.springclinic.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.clinic.springclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
	public Owner findByLastName(String lastName);
}
