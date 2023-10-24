package com.nit.dao;

import com.nit.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeDao extends JpaRepository<Employee, Integer> {

}
