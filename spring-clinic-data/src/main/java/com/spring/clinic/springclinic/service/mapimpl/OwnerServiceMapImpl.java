package com.spring.clinic.springclinic.service.mapimpl;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.spring.clinic.springclinic.model.Owner;
import com.spring.clinic.springclinic.model.Pet;
import com.spring.clinic.springclinic.service.OwnerService;
import com.spring.clinic.springclinic.service.PetService;
import com.spring.clinic.springclinic.service.PetTypeService;

@Service
@Profile({"default","map"})
public class OwnerServiceMapImpl extends AbstractMapService<Owner, Long> implements OwnerService {
	private final PetService petService;
	private final PetTypeService petTypeService;
	
	public OwnerServiceMapImpl(PetService petService, PetTypeService petTypeService) {
		this.petService = petService;
		this.petTypeService = petTypeService;
	}
	
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
		if(object != null) {
			object.getPets().forEach(p -> {
				if(p.getPetType() != null) {
					if(p.getPetType().getId() == null) {
						p.setPetType(petTypeService.save(p.getPetType()));
					}
				}else {
					throw new RuntimeException("PetType is requiered");
				}
				
				if(p.getId() == null) {
					Pet savedPet = petService.save(p);
					p.setId(savedPet.getId());
				}
			});
		
			return super.save(object);
		}else {
			return null;
		}						
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
