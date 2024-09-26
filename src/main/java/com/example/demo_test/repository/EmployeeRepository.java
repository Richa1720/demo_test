package com.example.demo_test.repository;

import com.example.demo_test.entity.Employee;
import java.util.List;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //@Query used to create query manually
//E is alias here
    @Query(value = "SELECT E FROM Employee E " +
            "WHERE E.company = :company AND E.doj >= :doj")
    List<Employee> findAllByCompanyAndDoj(String company, Date doj);  //UD
    //E.company is from Employee entity while :company is param passed in given method



    //nativeQuery is used to pass sql type query

    @Query(value = "SELECT * from employees where e_company=:company AND doj=:doj",nativeQuery = true)
    List<Employee> findAllByCompanyAndDoj1(String company, Date doj);  //UD


}
