package pro.sky.java.course2.EmployeeSpring.service;
import pro.sky.java.course2.EmployeeSpring.dte.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String name, String lastname);

    Employee removeEmployees(String name, String lastname);

    Employee findEmployee(String name, String lastname);
    Collection<Employee> findAllEmployee();
}
