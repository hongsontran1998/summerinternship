package com.demo.service.service.impl;

import com.demo.service.StorageProperties;
import com.demo.service.StorageService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    ServletContext servletContext;

    private String uploadDir;

    @Autowired
    public StorageServiceImpl(StorageProperties properties) {
        uploadDir = properties.getLocation();
    }

    @Override
    public int store(MultipartFile file) {
        File dir = createFolder();
        return uploadOneFile(file, dir);
    }

    @Override
    public int store(MultipartFile[] files) {
        File dir = createFolder();
        int totalOfUploadedFiles = 0;
        for (MultipartFile cmf : files) {
            totalOfUploadedFiles += uploadOneFile(cmf, dir);
        }
        return totalOfUploadedFiles;
    }

    @Override
    public void storeWithThread(MultipartFile[] files) {
        File dir = createFolder();
        Thread thread = new Thread(() -> {
            for (MultipartFile cmf : files) {
                uploadOneFile(cmf, dir);
            }
        });
        thread.start();
    }

    private int uploadOneFile(MultipartFile file, File dir) {
        System.out.println(dir.getAbsolutePath());
        int totalOfUploadedFiles = 0;
        String originalFilename = file.getOriginalFilename();
        if (!"".equals(originalFilename)) {
            try {
                file.transferTo(
                        new File(dir.getAbsolutePath() + File.separator
                        + FilenameUtils.getBaseName(originalFilename)
                        + "-" + System.nanoTime() + "." + FilenameUtils.getExtension(originalFilename))
                );
                totalOfUploadedFiles++;
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        }
        return totalOfUploadedFiles;
    }

    private File createFolder() {
        final String DIR_PATH = servletContext.getRealPath("") + uploadDir;
        File dir = new File(DIR_PATH);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }

    // TODO: 8/14
    @Override
    public File getFileFromStorage() {
        return null;
    }

    // TODO: 8/14
    @Override
    public int deleteFileFromStorage(String filename) {
        return 0;
    }
}
