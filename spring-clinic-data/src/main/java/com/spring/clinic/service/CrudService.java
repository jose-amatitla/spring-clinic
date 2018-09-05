package com.spring.clinic.service;

import java.util.Set;

public interface CrudService<T, ID> {
	T findById(ID id);
	Set<T> findAll();
	T save(T object);
	void delete(T Object);
	void deleteById(ID id);
}
