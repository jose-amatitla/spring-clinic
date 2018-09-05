package com.spring.clinic.springclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.clinic.model.Owner;
import com.spring.clinic.model.Vet;
import com.spring.clinic.service.OwnerService;
import com.spring.clinic.service.VetService;
import com.spring.clinic.service.mapimpl.OwnerServiceMapImpl;
import com.spring.clinic.service.mapimpl.VetServiceMapImpl;

@Component
public class DataLoader implements CommandLineRunner{
    private final OwnerService ownerService;
    private final VetService vetService;
	
    public DataLoader() {
		this.ownerService = new OwnerServiceMapImpl();
		this.vetService = new VetServiceMapImpl();
    }    
    
	@Override
	public void run(String... args) throws Exception {
            loadData();
	}
	
	private void loadData() {
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");

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
