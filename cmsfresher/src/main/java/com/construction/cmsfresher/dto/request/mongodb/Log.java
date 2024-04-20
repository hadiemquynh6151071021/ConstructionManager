package com.construction.cmsfresher.dto.request.mongodb;

import java.time.LocalDateTime;

public class Log {
	private String name;
	private Integer actorid;
	private LocalDateTime timestamp = LocalDateTime.now();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getActorid() {
		return actorid;
	}

	public void setActorid(Integer actorid) {
		this.actorid = actorid;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		
		this.timestamp =timestamp;
	}
	
}
