package com.example.demo_test.service.Impl;


import com.example.demo_test.entity.Employee;
import com.example.demo_test.repository.EmployeeRepository;
import com.example.demo_test.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    //here we are injecting dependency of repository class to service (which can also be done by @Autowired)
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {

//here we are applying condition
//if date is given at run time then same date will be set in employee or else new current date will be set in employee
        employee.setDoj(Optional.ofNullable(employee.getDoj()).orElse(new Date()));

        return employeeRepository.save(employee);  //to insert data save() method is used
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        Optional<Employee> optionalEmployee=employeeRepository.findById(employeeId);
        return optionalEmployee.orElse(null);  //to fetch we get()
    }

    @Override
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();  //to get list or all row from the table
    }

    @Override
    public Employee updateEmployee(Employee employee) {

        //lOgic
        Employee existingEmployee=employeeRepository.findById(employee.getId()).get();
        existingEmployee.setName(employee.getName());
        existingEmployee.setCompany(employee.getCompany());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDoj(Optional.ofNullable(employee.getDoj()).orElse(new Date()));
        existingEmployee.setDepartment(employee.getDepartment());


        //Accessors annotation use
        //existingEmployee.setName(employee.getName())
        // .setCompany(employee.getCompany())
        // .setEmail(employee.getEmail())
        // .setDoj(employee.getDoj())

        Employee updateEmployee=employeeRepository.save(existingEmployee);
        return updateEmployee;
    }

    @Override
    public void deleteEmployee(Long employeeId) {

       employeeRepository.deleteById(employeeId);

    }
}
