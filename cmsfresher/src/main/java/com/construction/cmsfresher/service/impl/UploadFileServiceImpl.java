package com.construction.cmsfresher.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.construction.cmsfresher.service.IUploadFileService;

@Component
public class UploadFileServiceImpl implements IUploadFileService {

	@Autowired
	Cloudinary cloudinary;

	@Override
	public List<String> uploadFile(MultipartFile[] files) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		try {
			for (MultipartFile file : files) {
				Map map = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("resource_type", "auto"));
				String url = (String) map.get("url");
				list.add(url);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
