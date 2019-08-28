package com.demo.repository;

import java.util.Date;

public interface EmployeeRepositoryCustom {
 
    Long getMaxEmpId();
    Long updateEmployee(String empNo, String fullName, Date hireDate);
     
}