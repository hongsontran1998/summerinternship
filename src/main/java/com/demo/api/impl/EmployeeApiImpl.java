package com.demo.api.impl;

import com.demo.api.CategoryApi;
import com.demo.api.EmployeeApi;
import com.demo.entity.Category;
import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;
import com.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class EmployeeApiImpl implements EmployeeApi {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity<List<Employee>> findAll() {
        return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
    }
}
