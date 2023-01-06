package com.greenbridge.controller;

import com.greenbridge.payload.FileResponse;
import com.greenbridge.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;
    @Value("${project.image}")
    private String path;

    @PostMapping("/upload")
    public ResponseEntity<FileResponse> fileUpload(@RequestParam("image")MultipartFile image) {

        String fileNmae = null;
        FileResponse fileResponse = new FileResponse();
        try {
            fileNmae = fileService.uploadImage(path,image);
        } catch (IOException e) {
            fileResponse.setFileName(null);
            fileResponse.setMessage("File was not uploaded due to some error in the backend server");
            return new ResponseEntity<FileResponse>(fileResponse, HttpStatus.INTERNAL_SERVER_ERROR);        }

        fileResponse.setFileName(fileNmae);
        fileResponse.setMessage("file was successfully uploaded");

        return new ResponseEntity<FileResponse>(fileResponse, HttpStatus.OK);
    }
}
