package com.dci.awsDemo.infra.rest;

import com.dci.awsDemo.domain.DomainEmployeeService;
import com.dci.awsDemo.domain.EmployeeRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AwsController {

    private final DomainEmployeeService employeeService;

    @Autowired
    public AwsController(DomainEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/helloAws")
    public String helloAws() {
        return "Hello from EC2!";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody EmployeeRecord record) {
        employeeService.addNewEmployee(record);
        return "Employee saved!";
    }

    @GetMapping("/listEmployees")
    public String listEmployees() {
        return employeeService.listEmployees()
                .stream()
                .map(EmployeeRecord::getName)
                .reduce((s, s2) -> String.join(", ", s, s2))
                .orElse("No Employees found!");
    }
}
