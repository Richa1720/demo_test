package com.example.demo_test.controller;

import com.example.demo_test.entity.Department;
import com.example.demo_test.service.DepartmentSevice;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/department")
public class DepartmentController {

    private DepartmentSevice departmentSevice;

    //Create Employee Rest API
    @RequestMapping(path="/create/dept",method= RequestMethod.POST)
    public ResponseEntity<Department> createDepartment(@RequestBody Department department)
    {
        Department savedDepartment=departmentSevice.createDepartment(department);

        return new ResponseEntity<>(savedDepartment,HttpStatus.CREATED);
    }

    //build get department Rest API
    @GetMapping("{departmentId}")  //  @GetMapping({"id"})
    public ResponseEntity<Department> getDepartmentById(@PathVariable int departmentId)
    {
        Department getDepartment=departmentSevice.getDepartmentById(departmentId);
        return new ResponseEntity<>(getDepartment,HttpStatus.OK);
    }

    //get all departments Rest API
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments()
    {
        List<Department> getDepartments=departmentSevice.getAllDepartments();
        return new ResponseEntity<>(getDepartments,HttpStatus.OK);
    }

    //build update department Rest API
    @PutMapping("{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable("id") int departmentId,Department department)
    {
        department.setId(departmentId);
        Department updatedDepartment=departmentSevice.updateDepartment(department);
        return new ResponseEntity<>(updatedDepartment,HttpStatus.OK);
    }

    // build delete department Rest API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") int departmentId)
    {
        departmentSevice.deleteDepartment(departmentId);
        return new ResponseEntity<>("Department deleted Successfully",HttpStatus.OK);
    }

}
