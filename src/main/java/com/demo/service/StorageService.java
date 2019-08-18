package com.demo.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


public interface StorageService {

    int store(MultipartFile file);
    int store(MultipartFile[] files);
    void storeWithThread(MultipartFile[] files);
    File getFileFromStorage();
    int deleteFileFromStorage(String filename);
}
