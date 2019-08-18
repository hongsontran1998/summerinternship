package com.demo.repository;

import java.util.Date;

public interface EmployeeRepositoryCustom {
 
    long getMaxEmpId();
     
    long updateEmployee(String empNo, String fullName, Date hireDate);
     
}