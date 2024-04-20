package com.construction.cmsfresher.service;

public interface MapperConverter<D, E> {

	public D convertEntityToDto(E entity);

	public E convertDtoToEntity(D dto);
}
