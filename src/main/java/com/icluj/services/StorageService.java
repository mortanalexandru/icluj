package com.icluj.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class StorageService {

	@Value("${image.location}")
	private String path;

	public void store(MultipartFile file) {
		Path rootLocation = Paths.get(path);
        try {
            Files.copy(file.getInputStream(), rootLocation.resolve(file.getOriginalFilename()));
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
	
	
}
