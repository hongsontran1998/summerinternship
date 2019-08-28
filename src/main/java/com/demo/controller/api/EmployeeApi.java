package com.demo.controller.api;

import com.demo.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface EmployeeApi {

    @GetMapping("employee")
    ResponseEntity<List<Employee>> findAll();
}
