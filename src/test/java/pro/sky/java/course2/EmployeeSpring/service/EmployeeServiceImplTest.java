package pro.sky.java.course2.EmployeeSpring.service;

import org.junit.jupiter.api.Test;
import pro.sky.java.course2.EmployeeSpring.dto.Employee;
import pro.sky.java.course2.EmployeeSpring.exception.EmployeeNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    EmployeeServiceImpl underTest = new EmployeeServiceImpl();
    Employee employee = new Employee("Vlada", "Volkova", 350000, 1);
    @Test
    void addEmployee() {
    }

    @Test
    void removeEmployees_employeeIsNotInMap_throwsException() {
        EmployeeNotFoundException ex =
        assertThrows(EmployeeNotFoundException.class, () ->
        underTest.removeEmployees(employee.getName(),employee.getLastname() ));
        assertEquals("Удаляемый сотрудник не найден", ex.getMessage());
    }

    @Test
    void findEmployee() {
    }

    @Test
    void findAllEmployee() {
    }
}