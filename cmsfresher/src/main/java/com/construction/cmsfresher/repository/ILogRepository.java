package com.construction.cmsfresher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.construction.cmsfresher.dto.request.mongodb.Log;

public interface ILogRepository extends MongoRepository<Log, String> {

}
