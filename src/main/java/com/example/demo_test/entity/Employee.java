package com.example.demo_test.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Lazy;

import java.util.Date;
/* @ToString(), @EqualsAndHashCode , @Getter on all fields, @Setter on non-final fields , @RequiredArgsConstructor */
@Data
@Accessors(chain = true)
@Entity
@Table(name="employees")
public class Employee {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="e_name")
    private String name;
    @Column(name="e_company")
    private String company;
    @Column
    private String email;
    //@Temporal(TemporalType.DATE)
    private Date doj;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="department_id")
    private Department department;

}
