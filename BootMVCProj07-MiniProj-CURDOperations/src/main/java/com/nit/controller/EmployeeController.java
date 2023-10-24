package com.nit.controller;

import com.nit.model.Employee;
import com.nit.service.IEmployeeService;
import com.nit.validation.EmployeeValidation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private EmployeeValidation employeeValidation;


    @GetMapping("/")
    public String showHome() {
        return "home";
    }


    @GetMapping("/report")
    public String showEmplooyeeReport(Map<String, Object> map) {
        // put the result in the model attribute
        map.put("empList", employeeService.getAllEmployees());
        // return LVN
        return "report";
    }

    @GetMapping("/add_emp")
    public String showFormToSaveEmployee(@ModelAttribute("emp") Employee employee) {
        return "register_employee";
    }

    @PostMapping("/add_emp")
    // we can use HttpSession parameter instead of RedirectAttribute if we want the data available for every request scope
    public String saveEmployee(@ModelAttribute("emp") Employee employee, RedirectAttributes attributes, BindingResult errors) {
        if(employeeValidation.supports(employee.getClass())){
            employeeValidation.validate(employee, errors);

            if(errors.hasErrors()) {
                return "register_employee";
            }
        }
        //use service
        String msg = employeeService.registerEmployee(employee);
        Iterable<Employee> allEmployees = employeeService.getAllEmployees();
        // keep the result in the model attribute scope
        attributes.addFlashAttribute("resultMsg", msg);
        //session.setAttribute("resultMsg", msg);
        // return LVN
        return "redirect:report"; // PRG PATTERN post redirect get so that to solve problem of duplicate adding etc if click on refresh button
    }

    @GetMapping("/emp_edit")
    public String showEditEmployeeFormPage(@RequestParam("no") int no, @ModelAttribute("emp") Employee employee) {
        // use service
        Employee employee1 = employeeService.getEmployeeByNo(no);
        // copy data
        BeanUtils.copyProperties(employee1, employee);
        //return lvn
        return "update_employee";
    }

    @PostMapping("/emp_edit")
    public String editEmployee(@ModelAttribute("emp") Employee employee, RedirectAttributes redirectAttributes) {
       String resultMsg =  employeeService.updateEmployee(employee);
       redirectAttributes.addFlashAttribute("updateMsg", resultMsg);
       return "redirect:report";
    }

    @GetMapping("/emp_delete")
    public String deleteEmployee(@RequestParam("no") int empno, RedirectAttributes redirectAttributes) {
        // use service
        String msg = employeeService.deleteEmployeeById(empno);
        // add in redirection shared memory
        redirectAttributes.addFlashAttribute("deleteMsg", msg);
        // redirect the request
        return "redirect:report";
    }

}
