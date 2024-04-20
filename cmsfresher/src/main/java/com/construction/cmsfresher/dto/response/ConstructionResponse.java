package com.construction.cmsfresher.dto.response;

public class ConstructionResponse {

	private Integer constructionsiteid;
	private String constructionsitename;

	public Integer getConstructionsiteid() {
		return constructionsiteid;
	}

	public void setConstructionsiteid(Integer constructionsiteid) {
		this.constructionsiteid = constructionsiteid;
	}

	public String getConstructionsitename() {
		return constructionsitename;
	}

	public void setConstructionsitename(String constructionsitename) {
		this.constructionsitename = constructionsitename;
	}

	public ConstructionResponse(Integer constructionsiteid, String constructionsitename) {
		this.constructionsiteid = constructionsiteid;
		this.constructionsitename = constructionsitename;
	}

	public ConstructionResponse() {
	}
	
	

}
