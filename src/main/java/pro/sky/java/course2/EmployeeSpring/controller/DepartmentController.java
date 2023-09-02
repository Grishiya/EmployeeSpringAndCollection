package pro.sky.java.course2.EmployeeSpring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.EmployeeSpring.dto.Employee;
import pro.sky.java.course2.EmployeeSpring.service.EmployeeDepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    public final EmployeeDepartmentService employeeDepartmentService;

    public DepartmentController(EmployeeDepartmentService employeeDepartmentService) {
        this.employeeDepartmentService = employeeDepartmentService;
    }


    @GetMapping("/max-salary")
    public Employee findMaxSalary(@RequestParam("departmentId") int department) {
        return employeeDepartmentService.findMaxSalaryEmployee(department);
    }

    @GetMapping("/min-salary")
    public Employee findMinSalary(@RequestParam("departmentId") int department) {
        return employeeDepartmentService.findMinSalaryEmployee(department);
    }

    @GetMapping("/all")
    public Collection<Employee> findAllDepartment(@RequestParam("departmentId") int department) {
        return employeeDepartmentService.findAllDepartmentEmployee(department);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAllGroupingByDepartment() {
        return employeeDepartmentService.getAllGroupingByDepartment();
    }
}
