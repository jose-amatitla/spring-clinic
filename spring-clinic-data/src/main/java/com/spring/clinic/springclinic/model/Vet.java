package com.spring.clinic.springclinic.model;

import java.util.Set;

public class Vet extends Person{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Set<Specialty> specialties;

	public Set<Specialty> getSpecialities() {
		return specialties;
	}

	public void setSpecialities(Set<Specialty> specialities) {
		this.specialties = specialities;
	}
}
