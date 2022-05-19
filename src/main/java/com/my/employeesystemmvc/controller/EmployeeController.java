package com.my.employeesystemmvc.controller;

import com.my.employeesystemmvc.model.Employee;
import com.my.employeesystemmvc.service.EmployeeService;
import com.my.employeesystemmvc.validation.groups.AddValidation;
import com.my.employeesystemmvc.validation.groups.UpdateValidation;
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

    @RequestMapping("/employees/employee/processAdd")
    public String addEmployee(@Validated(AddValidation.class) @ModelAttribute("add_employee") Employee employee, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "employee_form";
        }

        employeeService.addRecord(employee);

        return "redirect:/mvc/employees/list";
    }

    @RequestMapping("/employees/editForm")
    public String showEmployeeEditForm(@ModelAttribute("id") Integer id, Model theModel){

        Employee employee = employeeService.getRecordById(id);
        theModel.addAttribute("edit_employee", employee);

        return "edit_form";

    }

    @RequestMapping("/employees/processEdit")
    public String updateEmployee(@Validated(UpdateValidation.class) @ModelAttribute("edit_employee") Employee employee, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "edit_form";
        }

        employeeService.updateRecord(employee);

        return "redirect:/mvc/employees/list";

    }
}
