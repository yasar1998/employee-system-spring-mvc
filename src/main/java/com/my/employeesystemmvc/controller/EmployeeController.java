package com.my.employeesystemmvc.controller;

import com.my.employeesystemmvc.model.Employee;
import com.my.employeesystemmvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/mvc")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employees/list")
    public String getAllEmployees(Model theModel){

        theModel.addAttribute("employees", employeeService.getAllRecords());

        return "employees";

    }

    @RequestMapping("/employees/delete")
    public String deleteEmployee(@RequestParam("id") Integer id){

        employeeService.deleteRecord(id);

        return "redirect:/mvc/employees/list";

    }

    @RequestMapping("/employees/employee/addForm")
    public String showEmployeeForm(Model theModel){

        Employee employee = new Employee();

        theModel.addAttribute("add_employee", employee);

        return "employee_form";
    }


}
