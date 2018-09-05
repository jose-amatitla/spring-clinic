package com.spring.clinic.springclinic.model;

public class Pet extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Owner owner;
	private PetType petType;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public PetType getPetType() {
		return petType;
	}
	public void setPetType(PetType petType) {
		this.petType = petType;
	}
}