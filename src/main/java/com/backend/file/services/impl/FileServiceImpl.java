package com.backend.file.services.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.backend.file.services.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		
		//file Name
		String name = file.getOriginalFilename();
		
		//abc.png
		String rendomId = UUID.randomUUID().toString();
		String fileName1 = rendomId.concat(name.substring(name.lastIndexOf(".")));
		
		
		//full  Path
		
		String filePath = path+File.separator+fileName1;
		
		//create folder if not created
		
	   File f = new File(path);
	   if(!f.exists())
	   {
		   f.mkdir();
	   }
		
		//file copy
	   
	   Files.copy(file.getInputStream(),Paths.get(filePath));
		
		return name;
	}

}
