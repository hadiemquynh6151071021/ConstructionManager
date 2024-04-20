package com.construction.cmsfresher.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {

	public List<String> uploadFile(MultipartFile[] files);
}
