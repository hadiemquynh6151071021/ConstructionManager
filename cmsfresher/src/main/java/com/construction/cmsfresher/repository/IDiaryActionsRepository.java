package com.construction.cmsfresher.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.construction.cmsfresher.model.CmsDiaryAction;

public interface IDiaryActionsRepository extends JpaRepository<CmsDiaryAction, Integer>{

}
