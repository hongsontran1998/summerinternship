package com.demo.controller;

import com.demo.repository.SpringBootHibernateDAO;
import com.demo.security.UserDetailsUtil;
import com.demo.service.StorageService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    StorageService storageService;

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

    //// TODO: 8/13 error 405
    //error 405
    @PostMapping("uploads")
    public String test() {
        return "redirect:/admin/upload?upload=ok";
    }

    @RequestMapping(value = "/download1", method = RequestMethod.GET)
    public void download1(HttpServletResponse response) throws IOException {
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
    public ResponseEntity<InputStreamResource> download2(HttpServletRequest request) throws IOException {
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
            return new ResponseEntity<InputStreamResource>(inputStreamResource, responseHeader, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<InputStreamResource>(null, responseHeader, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
