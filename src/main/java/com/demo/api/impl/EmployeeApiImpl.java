package com.demo.api.impl;

import com.demo.api.EmployeeApi;
import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class EmployeeApiImpl implements EmployeeApi {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeApiImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ResponseEntity<List<Employee>> findAll() {
        return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
    }
}
