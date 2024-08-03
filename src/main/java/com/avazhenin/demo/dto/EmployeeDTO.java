package com.avazhenin.demo.dto;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Data
@Entity(name = "employee")
@Table(uniqueConstraints = {
    @UniqueConstraint(name = "fio", columnNames = {"name, surname"})
})
public class EmployeeDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String surname;
    private Long salary;
    @ManyToOne
    @Cascade(CascadeType.PERSIST)
    @JoinColumn(name = "department_dto_id")
    DepartmentDTO department;
}
