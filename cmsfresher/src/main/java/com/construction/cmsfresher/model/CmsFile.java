package com.construction.cmsfresher.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the cms_file database table.
 * 
 */
@Entity
@Table(name="cms_file")
@NamedQuery(name="CmsFile.findAll", query="SELECT c FROM CmsFile c")
public class CmsFile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer fileid;

	private String filelink;

	private byte[] filename;

	private Integer filetype;

	//bi-directional many-to-one association to CmsConstructionDiary
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="diaryid")
	private CmsConstructionDiary cmsConstructionDiary;

	public CmsFile() {
	}

	public Integer getFileid() {
		return this.fileid;
	}

	public void setFileid(Integer fileid) {
		this.fileid = fileid;
	}

	public String getFilelink() {
		return this.filelink;
	}

	public void setFilelink(String filelink) {
		this.filelink = filelink;
	}

	public byte[] getFilename() {
		return this.filename;
	}

	public void setFilename(byte[] filename) {
		this.filename = filename;
	}

	public Integer getFiletype() {
		return this.filetype;
	}

	public void setFiletype(Integer filetype) {
		this.filetype = filetype;
	}

	public CmsConstructionDiary getCmsConstructionDiary() {
		return this.cmsConstructionDiary;
	}

	public void setCmsConstructionDiary(CmsConstructionDiary cmsConstructionDiary) {
		this.cmsConstructionDiary = cmsConstructionDiary;
	}

}