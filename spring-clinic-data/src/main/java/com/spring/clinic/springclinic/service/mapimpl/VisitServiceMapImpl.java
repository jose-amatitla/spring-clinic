package com.spring.clinic.springclinic.service.mapimpl;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.spring.clinic.springclinic.model.Visit;
import com.spring.clinic.springclinic.service.VisitService;

@Service
public class VisitServiceMapImpl extends AbstractMapService<Visit, Long> implements VisitService {

	@Override
	public Visit findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Set<Visit> findAll() {
		return super.findAll();
	}

	@Override
	public Visit save(Visit object) {
		if(object.getPet() == null || object.getPet().getOwner() == null 
				|| object.getPet().getId() == null || object.getPet().getOwner().getId() == null) {
			throw new RuntimeException("Invalid Visit Entityy");
		}
		
		return super.save(object);
	}

	@Override
	public void delete(Visit object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}
}
