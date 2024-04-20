package com.construction.cmsfresher.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.construction.cmsfresher.model.MdProduct;

public interface IProductRepository extends JpaRepository<MdProduct, Integer>{

}
