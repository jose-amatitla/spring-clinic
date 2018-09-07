package com.spring.clinic.springclinic.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.clinic.springclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
