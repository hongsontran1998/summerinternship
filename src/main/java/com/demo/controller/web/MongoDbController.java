package com.demo.controller.web;

import com.demo.email.EmailSendingSystem;
import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;
import com.demo.repository.EmployeeRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("mongo")
public class MongoDbController {
    @Autowired
    private Environment env;
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    EmailSendingSystem emailSendingSystem;

    private static final String[] NAMES = { "Tom", "Jerry", "Donald" };

    @Autowired
    private EmployeeRepository employeeRepository;

    @ResponseBody
    @RequestMapping("")
    public String home() {
        String html = "";
        html += "<ul>";
        html += " <li><a href='mongo/testInsert'>Test Insert</a></li>";
        html += " <li><a href='mongo/showAllEmployee'>Show All Employee</a></li>";
        html += " <li><a href='mongo/showFullNameLikeTom'>Show All 'Tom'</a></li>";
        html += " <li><a href='mongo/deleteAllEmployee'>Delete All Employee</a></li>";
        html += "</ul>";
        return html;
    }

    @ResponseBody
    @RequestMapping("testInsert")
    public String testInsert() {
        Employee employee = new Employee();
        long id = employeeRepository.getMaxEmpId() + 1;
        int idx = (int) (id % NAMES.length);
        String fullName = NAMES[idx] + " " + id;
        employee.setId(id);
        employee.setEmpNo("E" + id);
        employee.setFullName(fullName);
        employee.setHireDate(new Date());
        this.employeeRepository.insert(employee);
        return "Inserted: " + employee;
    }

    @ResponseBody
    @RequestMapping("showAllEmployee")
    public String showAllEmployee() {
        List<Employee> employees = this.employeeRepository.findAll();
        StringBuilder html = new StringBuilder();
        for (Employee emp : employees) {
            html.append(emp).append("<br>");
        }
        return html.toString();
    }

    @ResponseBody
    @RequestMapping("showFullNameLikeTom")
    public String showFullNameLikeTom() {
        List<Employee> employees = this.employeeRepository.findByFullNameLike("Tom");
        StringBuilder html = new StringBuilder();
        for (Employee emp : employees) {
            html.append(emp).append("<br>");
        }
        return html.toString();
    }

    @ResponseBody
    @RequestMapping("deleteAllEmployee")
    public String deleteAllEmployee() {
        this.employeeRepository.deleteAll();
        return "Deleted!";
    }

}
