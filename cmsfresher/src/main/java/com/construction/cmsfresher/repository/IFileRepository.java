package com.construction.cmsfresher.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.construction.cmsfresher.model.CmsFile;

public interface IFileRepository extends JpaRepository<CmsFile, Integer>{

}
