package com.example.demo_test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain=true)     
@Entity
@Table(name="departments")
public class Department {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String departmentName;

    @OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL,mappedBy="department")
    @EqualsAndHashCode.Exclude   //excluding @Data's this annotation on this field
    @ToString.Exclude   //excluding @Data's this annotation on this field
    //@JsonIgnore
    private List<Employee> employees=new ArrayList<>();

}
