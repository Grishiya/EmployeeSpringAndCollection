package pro.sky.java.course2.EmployeeSpring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.EmployeeSpring.dte.Employee;
import pro.sky.java.course2.EmployeeSpring.service.EmployeeService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String name, @RequestParam String lastName) {
        return employeeService.addEmployee(name, lastName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String name, @RequestParam String lastName) {
        return employeeService.removeEmployees(name, lastName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String name, @RequestParam String lastName) {
        return employeeService.findEmployee(name, lastName);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return employeeService.findAllEmployee();
    }
}

