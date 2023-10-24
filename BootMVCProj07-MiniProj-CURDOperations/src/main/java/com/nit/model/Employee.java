package com.nit.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EMPLOYEE_TBL")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {

    @Id
    @SequenceGenerator(name="gen1", sequenceName = "emp_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
    private Integer empno;
    @Column(length = 20)
    private String ename;
    @Column(length = 20)
    private String job;
    private Float sal;
    private Integer deptno;

    public Employee(String name, String job, Float sal, int deptno ) {
        this.ename = name;
        this.job = job;
        this.sal = sal;
        this.deptno = deptno;

    }
}
