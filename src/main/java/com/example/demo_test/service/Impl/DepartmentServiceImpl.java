package com.example.demo_test.service.Impl;

import com.example.demo_test.entity.Department;
import com.example.demo_test.repository.DepartmentRepository;
import com.example.demo_test.service.DepartmentSevice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentSevice {

    private DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(Department department) {

        departmentRepository.save(department);
        return department;
    }

    @Override
    public Department getDepartmentById(int departmentId) {
        Optional<Department> optionalDepartment=departmentRepository.findById(departmentId);
        return optionalDepartment.get();
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> allDepartments=departmentRepository.findAll();
        return allDepartments;
    }

    @Override
    public Department updateDepartment(Department department) {
        Department existingDepartment=departmentRepository.findById(department.getId()).get();  //why not optional here????
        existingDepartment.setDepartmentName(department.getDepartmentName()).setEmployees(department.getEmployees());
        Department updateDept=departmentRepository.save(existingDepartment);
        return updateDept;
    }

    @Override
    public void deleteDepartment(int departmentId) {

        departmentRepository.deleteById(departmentId);

    }
}
