package com.spring.clinic.springclinic.service.mapimpl;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.spring.clinic.springclinic.model.Specialty;
import com.spring.clinic.springclinic.service.SpecialtyService;

@Service
public class SpecialtyServiceMapImpl extends AbstractMapService<Specialty, Long> implements SpecialtyService {

	@Override
	public Specialty findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Set<Specialty> findAll() {
		return super.findAll();
	}

	@Override
	public Specialty save(Specialty object) {
		return super.save(object);
	}

	@Override
	public void delete(Specialty object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
