package com.construction.cmsfresher.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.construction.cmsfresher.dto.request.mongodb.Log;
import com.construction.cmsfresher.repository.ILogRepository;

import jakarta.transaction.Transactional;

@Component
public class LogMongoError {
	@Autowired
	ILogRepository logRepository;

	@Transactional()
	public void logLaborError(String e, Integer id) {
		Log log = new Log();
		log.setName(e);
		log.setActorid(id);
		logRepository.save(log);
	}
}
