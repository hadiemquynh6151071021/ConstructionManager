package com.construction.cmsfresher.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.construction.cmsfresher.model.MdTask;

public interface ITaskRepository extends JpaRepository<MdTask, Integer>{

}
