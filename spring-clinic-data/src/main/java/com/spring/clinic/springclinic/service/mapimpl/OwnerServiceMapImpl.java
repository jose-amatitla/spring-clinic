package com.spring.clinic.springclinic.service.mapimpl;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.spring.clinic.springclinic.model.Owner;
import com.spring.clinic.springclinic.service.OwnerService;

@Service
public class OwnerServiceMapImpl extends AbstractMapService<Owner, Long> implements OwnerService {

	@Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
	
	@Override
	public Owner save(Owner object) {
		// TODO Auto-generated method stub
		return super.save(object.getId(), object);
	}

	@Override
	public void delete(Owner object) {
		super.delete(object);
	}
	 
	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}	
	
	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}	
}
