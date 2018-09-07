package com.spring.clinic.springclinic.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.clinic.springclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
