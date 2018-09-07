package com.spring.clinic.springclinic.service.jpaimpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.spring.clinic.springclinic.model.Owner;
import com.spring.clinic.springclinic.repository.OwnerRepository;
import com.spring.clinic.springclinic.service.OwnerService;

@Service
@Profile("jpa")
public class OwnerServiceJPAImpl implements OwnerService{
	private final OwnerRepository ownerRepository;
	
	public OwnerServiceJPAImpl(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}
	
	@Override
	public Owner findById(Long id) {		
		return ownerRepository.findById(id).orElse(null);
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();		
		ownerRepository.findAll().forEach(owners::add);
		
		return owners;
	}

	@Override
	public Owner save(Owner object) {
		return ownerRepository.save(object);
	}

	@Override
	public void delete(Owner object) {
		ownerRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return ownerRepository.findByLastName(lastName);
	}

}
