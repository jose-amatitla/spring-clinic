package com.spring.clinic.service;

import com.spring.clinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
	Owner findByLastName(String lastName);
}
