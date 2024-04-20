package com.construction.cmsfresher.service;

import java.util.List;

public interface DaoService<E,K> {

	E save(E entity);
	
	E findById(K id);
	
	List<E> findAll();
	
}
