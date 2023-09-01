package pro.sky.java.course2.EmployeeSpring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.EmployeeSpring.dto.Employee;
import pro.sky.java.course2.EmployeeSpring.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String name, @RequestParam String lastName,
                        @RequestParam double salary,  @RequestParam int department) {
        return employeeService.addEmployee(name, lastName, salary, department);
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


