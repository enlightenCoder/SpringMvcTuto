package com.nit.service;

import com.nit.model.Employee;

public interface IEmployeeService {

    Iterable<Employee> getAllEmployees();

    String registerEmployee(Employee employee);

    Employee getEmployeeByNo(int eno);

    String updateEmployee(Employee employee);

    String deleteEmployeeById(int eno);
}
