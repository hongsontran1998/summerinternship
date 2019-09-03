package com.demo.controller.web;

import com.demo.service.StorageService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

@Controller
@RequestMapping("admin")
public class AdminController {

    private final StorageService storageService;

    @Autowired
    public AdminController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("dashboard")
    public String dashboard() {
        return "admin/dashboard";
    }

    @GetMapping("about")
    @ResponseBody
    public String about() {
        return "about";
    }

    @GetMapping("upload")
    public String upload() {
        return "admin/file_uploading";
    }

   @PostMapping("upload")
    public String upload(@RequestParam("files") CommonsMultipartFile[] commonsMultipartFiles) {
        //int totalOfUploadedFiles = storageService.store(commonsMultipartFiles);
       storageService.storeWithThread(commonsMultipartFiles);
        return "redirect:/admin/upload?upload=ok";
    }

    @PostMapping("upload-ajax")
    @ResponseBody
    public String uploadAjax(@RequestParam("files") CommonsMultipartFile[] commonsMultipartFiles) {
        //storageService.storeWithThread(commonsMultipartFiles);
        storageService.store(commonsMultipartFiles);
        return "OK";
    }

    @RequestMapping(value = "/download1", method = RequestMethod.GET)
    public void download1(HttpServletResponse response) {
        try {
            File file = ResourceUtils.getFile("classpath:static/abc.png");
            byte[] data = FileUtils.readFileToByteArray(file);
            // setting response information
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment; filename=" + file.getName());
            response.setContentLength(data.length);
            InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(data));
            FileCopyUtils.copy(inputStream, response.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @RequestMapping(value = "/download2", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> download2() {
        HttpHeaders responseHeader = new HttpHeaders();
        try {
            File file = ResourceUtils.getFile("classpath:static/abc.png");
            byte[] data = FileUtils.readFileToByteArray(file);
            // Set mimeType trả về
            responseHeader.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            // Thiết lập thông tin trả về
            responseHeader.set("Content-disposition", "attachment; filename=" + file.getName());
            responseHeader.setContentLength(data.length);
            InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(data));
            InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
            return new ResponseEntity<>(inputStreamResource, responseHeader, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, responseHeader, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
