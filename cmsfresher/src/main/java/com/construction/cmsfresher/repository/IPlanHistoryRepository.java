package com.construction.cmsfresher.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.construction.cmsfresher.model.CmsPlanHistory;

public interface IPlanHistoryRepository extends JpaRepository<CmsPlanHistory, Integer> {

}
