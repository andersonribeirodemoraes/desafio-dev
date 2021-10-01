package com.br.cnabapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.br.cnabapi.model.UploadResponseMessage;
import com.br.cnabapi.service.CnabService;
import com.br.cnabapi.service.FileService;

@RestController
@RequestMapping("cnab")
public class CnabController {
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private CnabService cnabService;  
	
	@PostMapping
    public ResponseEntity<UploadResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            fileService.save(file);
            
            cnabService.execute();

            return ResponseEntity.status(HttpStatus.OK)
                                 .body(new UploadResponseMessage("Uploaded the file successfully: " + file.getOriginalFilename()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                                 .body(new UploadResponseMessage("Could not upload the file: " + file.getOriginalFilename() + "!"));
        }
    }

}
