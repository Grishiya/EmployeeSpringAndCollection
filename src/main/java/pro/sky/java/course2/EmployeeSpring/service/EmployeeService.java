package pro.sky.java.course2.EmployeeSpring.service;
import pro.sky.java.course2.EmployeeSpring.dto.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String name, String lastName, double salary, int department);

    Employee removeEmployees(String name, String lastname);

    Employee findEmployee(String name, String lastname);
    Collection<Employee> findAllEmployee();
}
