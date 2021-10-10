package com.dci.awsDemo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainEmployeeService implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public DomainEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void addNewEmployee(EmployeeRecord record) {
        employeeRepository.save(new Employee(record.name(), record.role()));
    }

    @Override
    public List<EmployeeRecord> listEmployees() {
        return employeeRepository
                .findAll()
                .stream()
                .map(employee -> new EmployeeRecord(employee.getName(), employee.getRole()))
                .toList();
    }
}
