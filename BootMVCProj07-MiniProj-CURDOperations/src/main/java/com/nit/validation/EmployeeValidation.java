package com.nit.validation;

import com.nit.model.Employee;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class EmployeeValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) { // to check whether current model class taken or not ???
        return clazz.isAssignableFrom(Employee.class);
    }


    // Place validation logic here
    @Override
    public void validate(Object target, Errors errors) {

        //Typecasting with model class
        Employee employee = (Employee) target;
        if(employee.getEname() == null || employee.getEname().isBlank())
            errors.rejectValue("ename", "emp.name.required");
        else if(employee.getEname().length() < 5 || employee.getEname().length() >= 15)
            errors.rejectValue("ename", "emp.name.length");

        if(employee.getJob() == null || employee.getJob().isBlank())
            errors.rejectValue("job", "emp.job.required");
        else if(employee.getEname().length() < 5 || employee.getEname().length() >= 15)
            errors.rejectValue("job", "emp.job.length");

        if(employee.getSal() == null)
            errors.rejectValue("sal", "emp.sal.required");
        else if(employee.getSal() < 10000.0 || employee.getSal() >= 200000.0)
            errors.rejectValue("sal", "emp.salary.range");

        if(employee.getDeptno() == null)
            errors.rejectValue("deptno", "emp.deptno.required");


    }
}
