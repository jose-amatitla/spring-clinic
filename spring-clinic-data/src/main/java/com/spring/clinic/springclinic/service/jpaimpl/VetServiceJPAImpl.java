package com.spring.clinic.springclinic.service.jpaimpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.spring.clinic.springclinic.model.Vet;
import com.spring.clinic.springclinic.repository.VetRepository;
import com.spring.clinic.springclinic.service.VetService;

@Service
@Profile("jpa")
public class VetServiceJPAImpl implements VetService {
	private final VetRepository vetRepository;
	
	public VetServiceJPAImpl(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}
	
	@Override
	public Vet findById(Long id) {
		return vetRepository.findById(id).orElse(null);
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets = new HashSet<>();
		vetRepository.findAll().forEach(vets::add);

		return vets;
	}

	@Override
	public Vet save(Vet object) {
		return vetRepository.save(object);
	}

	@Override
	public void delete(Vet object) {
		vetRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);
	}

}
