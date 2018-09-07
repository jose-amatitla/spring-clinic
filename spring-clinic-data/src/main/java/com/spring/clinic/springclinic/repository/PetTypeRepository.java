package com.spring.clinic.springclinic.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.clinic.springclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
