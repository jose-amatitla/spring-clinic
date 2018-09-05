package com.spring.clinic.service;

import java.util.Set;

import com.spring.clinic.model.Vet;

public interface VetService {
	Vet findById(Long id);	
	Vet save(Vet vet);
	Set<Vet> findAll();
}
