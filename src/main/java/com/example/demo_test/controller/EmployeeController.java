package com.example.demo_test.controller;

import com.example.demo_test.entity.Department;
import com.example.demo_test.entity.Employee;
import com.example.demo_test.repository.EmployeeRepository;
import com.example.demo_test.service.DepartmentSevice;
import com.example.demo_test.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   // combination of @Controller + @ResponseBody
@AllArgsConstructor    //
//@RequestMapping("api/employees")
//@RequestMapping("/api/employees")
//@RequestMapping(value={"varsha","api/employees","test"})   //@RequestMapping is not mandatory here it's working without applying here
public class EmployeeController {

    private EmployeeRepository employeeRepository;
    //private DepartmentSevice departmentSevice;
    //here we are injecting dependency of service class to controller (which can also be done by @Autowired)
    private EmployeeService employeeService;

    // build create Employee REST API
    // @PostMapping("/post1")

//TODO ResponseEntity represents the whole HTTP response:status code, headers, and body . As a result, we can use it
// to fully configure the HTTP response. If we want to use it, we have to return it from the endpoint;
// Spring takes care of the rest. ResponseEntity is a generic type

//TODO The @RequestBody and @RequestParam annotations in Spring MVC are used to extract data from the incoming HTTP
// request. In other words, both annotations are used to obtain data from the client's request in a Spring MVC controller.

    //@PostMapping   //this is new annotation for POST request     [@RequestMapping(path="/create/api")]   [@RequestMapping(value={"/create/api"}] both are same
    @RequestMapping(path = "/create/api", method = {RequestMethod.POST})  //we can use @RequestMapping on method as well
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.ACCEPTED);
    }

    // build get employee by id REST API
    // http://localhost:8080/api/employees/1
    @GetMapping("{id2}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id2") Long employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    // Build Get All Employees REST API
    // http://localhost:8080/api/employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);   //HttpStatus code is what we found on postman(it is used to
        // give status response )
    }

    // Build Update Employee REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/employees/1
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long employeeId,
                                                   @RequestBody Employee employee) {
        employee.setId(employeeId);  //setting id to the database   trial
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    // Build Delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>("Employee successfully deleted!", HttpStatus.OK);
    }


    //get record using company and doj
    @GetMapping("employees")
    public ResponseEntity<List<Employee>> getEmployees(@RequestBody Employee employee) {
        List<Employee> employees = employeeRepository.findAllByCompanyAndDoj(employee.getCompany(), employee.getDoj());
        return new ResponseEntity<>(employees, HttpStatus.OK);

    }


    // Test RequestParam
    @GetMapping("test")
    public ResponseEntity<String> getRequestParam(@RequestParam("name") String name) {
        return new ResponseEntity<>(name, HttpStatus.OK);
    }


}
