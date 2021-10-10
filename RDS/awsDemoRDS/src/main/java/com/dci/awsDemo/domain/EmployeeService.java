package com.dci.awsDemo.domain;

import java.util.List;

public interface EmployeeService {

    void addNewEmployee(EmployeeRecord record);

    List<EmployeeRecord> listEmployees();
}
