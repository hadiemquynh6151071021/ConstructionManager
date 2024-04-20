package com.construction.cmsfresher.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.construction.cmsfresher.model.CmsPlanWorkitem;

public interface IPlanWorkItemRepository extends JpaRepository<CmsPlanWorkitem, Integer>{

}
