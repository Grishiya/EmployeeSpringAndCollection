package pro.sky.java.course2.EmployeeSpring.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.EmployeeSpring.dto.Employee;
import pro.sky.java.course2.EmployeeSpring.exception.EmployeeNotFoundException;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeDepartmentServiceImpl implements EmployeeDepartmentService {

    private final EmployeeService employeeService;

    public EmployeeDepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findMaxSalaryEmployee(int department) {
        return employeeService.findAllEmployee().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparing(employee -> employee.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException("нет сотрудников в отделе " + department));
    }

    @Override
    public Employee findMinSalaryEmployee(int department) {
        return employeeService.findAllEmployee().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingDouble(employee -> employee.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException("нет сотрудников в отделе" + department));
    }

    @Override
    public Collection<Employee> findAllDepartmentEmployee(int department) {
        return employeeService.findAllEmployee().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllGroupingByDepartment() {
        return employeeService.findAllEmployee().stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment()));
    }

    @Override
    public double salaryCostsInTheDepartment(int department) {
        return employeeService.findAllEmployee().stream()
                .filter(employee -> employee.getDepartment() == department)
                .mapToDouble(employee -> employee.getSalary())
                .sum();

    }
}
