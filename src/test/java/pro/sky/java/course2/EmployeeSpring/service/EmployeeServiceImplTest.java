package pro.sky.java.course2.EmployeeSpring.service;

import org.junit.jupiter.api.Test;
import pro.sky.java.course2.EmployeeSpring.dto.Employee;
import pro.sky.java.course2.EmployeeSpring.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.EmployeeSpring.exception.EmployeeNotFoundException;
import pro.sky.java.course2.EmployeeSpring.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    EmployeeServiceImpl underTest = new EmployeeServiceImpl();
    Employee employee = new Employee("Vlada", "Volkova", 350000, 1);
    Employee employee1 = new Employee("Vlada1", "Volkova", 350000, 1);
    Employee employee2 = new Employee("Vlada2", "Volkova", 350000, 1);
    Collection<Employee> employees = new ArrayList<>(List.of(employee, employee1));

    @Test
    void removeEmployees_employeeIsNotInMap_throwsException() {
        EmployeeNotFoundException ex =
                assertThrows(EmployeeNotFoundException.class, () ->
                        underTest.removeEmployees(employee.getName(), employee.getLastname()));
        assertEquals("Удаляемый сотрудник не найден", ex.getMessage());
    }

    @Test
    void removeEmployees_employeeIsInMap_employeeRemovedAndReturn() {
        underTest.addEmployee(employee.getName(), employee.getLastname(),
                employee.getSalary(), employee.getDepartment());

        Employee result = underTest.removeEmployees(employee.getName(), employee.getLastname());
        assertEquals(employee, result);
        assertFalse(underTest.findAllEmployee().contains(employee));
    }

    @Test
    void addEmployee_employeesMoreThanLimit_throwsException() {
        underTest.addEmployee(employee.getName(), employee.getLastname(),
                employee.getSalary(), employee.getDepartment());
        underTest.addEmployee(employee1.getName(), employee1.getLastname(),
                employee1.getSalary(), employee1.getDepartment());


        EmployeeStorageIsFullException ex =
                assertThrows(EmployeeStorageIsFullException.class,
                        () -> underTest.addEmployee(employee2.getName(), employee2.getLastname(),
                                employee2.getSalary(), employee2.getDepartment()));
        assertEquals("Превышен лимит количества сотрудников в фирме", ex.getMessage());
    }

    @Test
    void addEmployee_employeeAlreadyInMap_throwsEmployeeAlreadyAddedException() {
        underTest.addEmployee(employee.getName(), employee.getLastname(),
                employee.getSalary(), employee.getDepartment());

        EmployeeAlreadyAddedException ex =
                assertThrows(EmployeeAlreadyAddedException.class,
                        () -> underTest.addEmployee(employee.getName(), employee.getLastname(),
                                employee.getSalary(), employee.getDepartment()));
        assertEquals("Добавляемый сотрудник уже имеется в списке", ex.getMessage());
    }

    @Test
    void addEmployee_employeePutInMap_employeeAddAndReturn() {
        Employee result = underTest.addEmployee(employee.getName(), employee.getLastname(),
                employee.getSalary(), employee.getDepartment());
        assertEquals(employee, result);
    }

    @Test
    void findEmployee_employeeNotInMap_throwsEmployeeNotFoundException() {
        EmployeeNotFoundException ex =
                assertThrows(EmployeeNotFoundException.class, () ->
                        underTest.findEmployee(employee.getName(), employee.getLastname()));
        assertEquals("Cотрудник не найден", ex.getMessage());
    }

    @Test
    void findEmployee_employeeInMap_returnEmployee() {
        underTest.addEmployee(employee.getName(), employee.getLastname(), employee.getSalary(),
                employee.getDepartment());
        Employee result = underTest.findEmployee(employee.getName(), employee.getLastname());
        assertEquals(employee, result);
    }

    @Test
    void findAllEmployee__returnAllEmployee() {
        underTest.addEmployee(employee.getName(), employee.getLastname(),
                employee.getSalary(), employee.getDepartment());
        underTest.addEmployee(employee1.getName(), employee1.getLastname(),
                employee1.getSalary(), employee1.getDepartment());

        Collection<Employee> result = underTest.findAllEmployee();
        assertTrue(result.containsAll(employees));
    }
}