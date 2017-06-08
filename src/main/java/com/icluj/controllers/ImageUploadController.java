package com.icluj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.icluj.services.StorageService;
@Controller
public class ImageUploadController {

	@Autowired
    private StorageService storageService;
	@RequestMapping(value="/file", method= RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {

        storageService.store(file);
        return "true";
    }
}
