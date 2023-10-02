package pro.sky.java.course2.EmployeeSpring.service;

import pro.sky.java.course2.EmployeeSpring.EmployeeSpringApplication;
import pro.sky.java.course2.EmployeeSpring.dto.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EmployeeDepartmentService {
    Employee findMaxSalaryEmployee(int department);

    Employee findMinSalaryEmployee(int department);

    Collection<Employee> findAllDepartmentEmployee(int department);

    Map<Integer, List<Employee>> getAllGroupingByDepartment();

   double salaryCostsInTheDepartment(int department);
}
