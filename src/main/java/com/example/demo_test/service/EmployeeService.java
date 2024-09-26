package com.example.demo_test.service;

import com.example.demo_test.entity.Employee;

import java.util.List;

public interface EmployeeService {


    //abstract methods
    Employee createEmployee(Employee employee);

    //to get single data
    Employee getEmployeeById(Long employeeId);

    //to get list of data from the table
    List<Employee> getAllEmployees();

    //to update record
    Employee updateEmployee(Employee employee);

    //to delete record
    void deleteEmployee(Long employeeId);



}
