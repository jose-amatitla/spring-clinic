package com.spring.clinic.springclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.clinic.springclinic.model.Owner;
import com.spring.clinic.springclinic.model.Pet;
import com.spring.clinic.springclinic.model.PetType;
import com.spring.clinic.springclinic.model.Specialty;
import com.spring.clinic.springclinic.model.Vet;
import com.spring.clinic.springclinic.model.Visit;
import com.spring.clinic.springclinic.service.OwnerService;
import com.spring.clinic.springclinic.service.PetTypeService;
import com.spring.clinic.springclinic.service.SpecialtyService;
import com.spring.clinic.springclinic.service.VetService;
import com.spring.clinic.springclinic.service.VisitService;

@Component
public class DataLoader implements CommandLineRunner{
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;
	
	public DataLoader(OwnerService ownerService, VetService vetService, 
			PetTypeService petTypeService, SpecialtyService specialtyService,
			VisitService visitService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
		this.visitService = visitService;
	}

	@Override
	public void run(String... args) throws Exception {
		int recordCount = ownerService.findAll().size();
		
		if(recordCount == 0) {
            loadData();
		}
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
        owner2.setAddress("246 Nth East");
        owner2.setCity("Seatlle");
        owner2.setTelephone("19888666555");
        
        Pet scooby = new Pet();
        scooby.setName("Scoobe Doo");
        scooby.setPetType(savedDog);
        scooby.setBirthDate(LocalDate.now());
        scooby.setOwner(owner2);
        
        owner2.getPets().add(scooby);

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");
        
        Visit catVisit = new Visit();
        catVisit.setDate(LocalDate.now());
        catVisit.setPet(tc);
        catVisit.setDescription("TC visit");
        visitService.save(catVisit);
        
        Visit dogVisit = new Visit();
        dogVisit.setDate(LocalDate.now());
        dogVisit.setPet(scooby);
        dogVisit.setDescription("TC visit");
        visitService.save(dogVisit);
                        
        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);
        
        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Linda");
        vet3.setLastName("Douglas");
        vet3.getSpecialities().add(savedDentistry);

        vetService.save(vet3);
        
        System.out.println("Loaded Vets....");
    }	
}
