package com.spring.clinic.springclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.clinic.springclinic.model.Owner;
import com.spring.clinic.springclinic.model.Pet;
import com.spring.clinic.springclinic.model.PetType;
import com.spring.clinic.springclinic.model.Vet;
import com.spring.clinic.springclinic.service.OwnerService;
import com.spring.clinic.springclinic.service.PetTypeService;
import com.spring.clinic.springclinic.service.VetService;

@Component
public class DataLoader implements CommandLineRunner{
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
	
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {
            loadData();
	}
	
	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDog = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCat = petTypeService.save(cat);
		
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("246 St West");
        owner1.setCity("Bellevue");
        owner1.setTelephone("1999888777");

        Pet tc = new Pet();
        tc.setName("Top Cat");
        tc.setPetType(savedCat);
        tc.setOwner(owner1);
        tc.setBirthDate(LocalDate.now());
        
        owner1.getPets().add(tc);
        
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner1.setAddress("246 Nth East");
        owner1.setCity("Seatlle");
        owner1.setTelephone("19888666555");
        
        Pet scooby = new Pet();
        scooby.setName("Scoobe Doo");
        scooby.setPetType(savedDog);
        scooby.setBirthDate(LocalDate.now());
        scooby.setOwner(owner2);
        
        owner2.getPets().add(scooby);

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");
        
        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }	
}
