package com.spring.clinic.springclinic.service.jpaimpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.spring.clinic.springclinic.model.Visit;
import com.spring.clinic.springclinic.repository.VisitRepository;
import com.spring.clinic.springclinic.service.VisitService;

@Service
@Profile("jpa")
public class VisitServiceJPAImpl implements VisitService {
	private final VisitRepository visitRepository;
	
	public VisitServiceJPAImpl(VisitRepository visitRepository) {
		this.visitRepository = visitRepository;
	}
	
	@Override
	public Visit findById(Long id) {
		return visitRepository.findById(id).orElse(null);
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> visits = new HashSet<>();
		visitRepository.findAll().forEach(visits::add);
		
		return visits;
	}

	@Override
	public Visit save(Visit object) {
		return visitRepository.save(object);
	}

	@Override
	public void delete(Visit object) {
		visitRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		visitRepository.deleteById(id);
	}
}
