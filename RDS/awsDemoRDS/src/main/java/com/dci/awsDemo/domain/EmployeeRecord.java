package com.dci.awsDemo.domain;

public record EmployeeRecord(String name, String role) {

    public String getName() {
        return String.format("Employee name %s with role: %s", name, role);
    }
}
