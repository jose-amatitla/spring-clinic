package com.spring.clinic.springclinic.service.mapimpl;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.spring.clinic.springclinic.model.Specialty;
import com.spring.clinic.springclinic.model.Vet;
import com.spring.clinic.springclinic.service.SpecialtyService;
import com.spring.clinic.springclinic.service.VetService;

@Service
public class VetServiceMapImpl extends AbstractMapService<Vet, Long> implements VetService{
	final SpecialtyService specialtyService;
		
	public VetServiceMapImpl(SpecialtyService specialtyService) {
		this.specialtyService = specialtyService;
	}
	
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
    	
    	object.getSpecialities().forEach( s ->{
    		if(s.getId() == null) {
    			Specialty specialty = specialtyService.save(s);
    			s.setId(specialty.getId());
    		}
    	});
    	    	
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }	

}
