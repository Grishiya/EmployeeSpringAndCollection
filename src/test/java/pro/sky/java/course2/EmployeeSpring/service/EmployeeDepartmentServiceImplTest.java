package pro.sky.java.course2.EmployeeSpring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.EmployeeSpring.dto.Employee;
import pro.sky.java.course2.EmployeeSpring.exception.EmployeeNotFoundException;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeDepartmentServiceImplTest {

    @Mock
    EmployeeService employeeService;

    @InjectMocks
    EmployeeDepartmentServiceImpl underTest;

    Employee vlada = new Employee("VLADA", "LOONA",
            100000, 1);
    Employee grigory = new Employee("GRIGORY", "VOLKOV",
            4030303, 1);
    Employee maria = new Employee("MARIA", "IVANOVA",
            200020, 3);

    Collection<Employee> employees = List.of(vlada, grigory, maria);

    @Test
    void findMaxSalaryEmployee_employeeFind_returnEmployeeWithMaxSalary() {
        when(employeeService.findAllEmployee()).thenReturn(employees);

        Employee result = underTest.findMaxSalaryEmployee(1);
        assertEquals(grigory, result);
    }

    @Test
    void findMaxSalaryEmployee_employeeNotFind_throwsEmployeeNotFoundException() {
        int department = 1;
        when(employeeService.findAllEmployee()).thenReturn(Collections.emptyList());

        EmployeeNotFoundException ex = assertThrows(EmployeeNotFoundException.class,
                () -> underTest.findMaxSalaryEmployee(department));
        assertEquals("нет сотрудников в отделе " + department, ex.getMessage());
    }

    @Test
    void findMinSalaryEmployee_employeeFind_returnEmployeeWithMMinSalary() {
        when(employeeService.findAllEmployee()).thenReturn(employees);

        Employee result = underTest.findMinSalaryEmployee(1);
        assertEquals(vlada, result);
    }

    @Test
    void findMinSalaryEmployee_employeeNotFind_throwsEmployeeNotFoundException() {
        int department = 1;
        when(employeeService.findAllEmployee()).thenReturn(Collections.emptyList());

        EmployeeNotFoundException ex = assertThrows(EmployeeNotFoundException.class,
                () -> underTest.findMinSalaryEmployee(department));
        assertEquals("нет сотрудников в отделе " + department, ex.getMessage());
    }

    @Test
    void findAllDepartmentEmployee_employeeInDepartment_returnListOfEmployeeInDepartment() {
        when(employeeService.findAllEmployee()).thenReturn(employees);

        Collection<Employee> result = underTest.findAllDepartmentEmployee(1);
        assertEquals(List.of(vlada, grigory), result);
    }

    @Test
    void getAllGroupingByDepartment_allEmployeeInMap_groupingEmployeeByDepartment() {
        when(employeeService.findAllEmployee()).thenReturn(employees);

        Map<Integer, List<Employee>> result = underTest.getAllGroupingByDepartment();
        assertEquals(Map.of(
                1, List.of(vlada, grigory), 3, List.of(maria)), result);
    }
    @Test
    void salaryCostsInTheDepartment() {
        when(employeeService.findAllEmployee()).thenReturn(employees);

       double result = underTest.salaryCostsInTheDepartment(1);
       assertEquals(4130303.0, result);
    }
}





