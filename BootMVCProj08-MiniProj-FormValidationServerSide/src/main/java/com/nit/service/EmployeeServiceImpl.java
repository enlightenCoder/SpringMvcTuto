package com.nit.service;

import com.nit.dao.IEmployeeDao;
import com.nit.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("empService")
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    private IEmployeeDao repository;
    @Override
    public Iterable<Employee> getAllEmployees() {

        return repository.findAll();
    }

    @Override
    public String registerEmployee(Employee employee) {
        return "employee is saved with id value:" + repository.save(employee);
    }

    @Override
    public Employee getEmployeeByNo(int eno) {
        return repository.findById(eno).orElseThrow(() -> new IllegalArgumentException());
    }

    @Override
    public String updateEmployee(Employee employee) {
        return "Employee is updates having id value " + repository.save(employee).getEmpno();
    }

    @Override
    public String deleteEmployeeById(int eno) {
        repository.deleteById(eno);
        return eno + " employee id is deleted";
    }
}
