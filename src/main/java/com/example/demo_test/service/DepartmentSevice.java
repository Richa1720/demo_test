package com.example.demo_test.service;

import com.example.demo_test.entity.Department;

import java.util.List;

public interface DepartmentSevice {


    //create
    Department createDepartment(Department department);

    //get

     Department getDepartmentById(int departmentId);

    //getAllDepartment

     List<Department> getAllDepartments();

     Department updateDepartment(Department department);

    //delete
     void deleteDepartment(int departmentId);
}
