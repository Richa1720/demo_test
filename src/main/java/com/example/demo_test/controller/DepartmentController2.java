package com.example.demo_test.controller;

import com.example.demo_test.entity.Department;
import com.example.demo_test.entity.Employee;
import com.example.demo_test.repository.DepartmentRepository;
import com.example.demo_test.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/departments")
public class DepartmentController2 {


    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;

    @PostMapping("/saveEmployeeWithDepartment")
    public ResponseEntity<Employee> saveEmployeeWithDepartment(@RequestBody Employee employee) {
        // Save the department first if it's a new one
        if (employee.getDepartment().getId() == null) {
            System.out.println("New Department");
            Department
                    savedDepartment = departmentRepository.save(employee.getDepartment());
            employee.setDepartment(savedDepartment);
        } else {
            System.out.println("Existing Department");
            // Ensure department is loaded
            Department existingDepartment = departmentRepository.findById(employee.getDepartment().getId())
                    .orElseThrow(() -> new RuntimeException("Department not found"));  //?????? useless

            employee.setDepartment(existingDepartment);

        }

        /* else {
            System.out.println("Existing Department");
            // Ensure department is loaded
            Optional<Department> existingDepartment = departmentRepository.findById(employee.getDepartment().getId());
                   // .orElseThrow(() -> new RuntimeException("Department not found"));  //?????? useless
            if(!existingDepartment.isPresent())

            {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);     // we can pass single parameter also
            }
            employee.setDepartment(existingDepartment.get());

        }*/

        // Save the employee
        Employee savedEmployee = employeeRepository.save(employee);

        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PostMapping("/saveDepartmentWithEmployee")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        System.out.println("Received Department: " + department);

        if (department.getEmployees() == null) {
            System.out.println("Employees list is null");
            department.setEmployees(new ArrayList<>()); // Initialize if null
        } else {
            System.out.println("Employees list size: " + department.getEmployees().size());
        } //else closed

        for (Employee employee : department.getEmployees()) {
            System.out.println("Employee before save: " + employee);
            employee.setDepartment(department);
        }

        Department savedDepartment = departmentRepository.save(department);
        System.out.println("Saved Department: " + savedDepartment);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);

    }

}

