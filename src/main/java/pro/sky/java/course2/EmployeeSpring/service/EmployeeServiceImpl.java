package pro.sky.java.course2.EmployeeSpring.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.EmployeeSpring.dto.Employee;
import pro.sky.java.course2.EmployeeSpring.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.EmployeeSpring.exception.EmployeeNotFoundException;
import pro.sky.java.course2.EmployeeSpring.exception.EmployeeStorageIsFullException;

import java.util.*;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employeeMap;
    private static final int EMPLOYEES_MAX_SIZE = 10;

    public EmployeeServiceImpl() {
        this.employeeMap = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String name, String lastName, double salary, int department) {
        if (employeeMap.keySet().size() == EMPLOYEES_MAX_SIZE) {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников в фирме");
        }
        Employee employee = new Employee(StringUtils.capitalize(name),
                StringUtils.capitalize(lastName),
                salary, department);
        String keyEmployee = generateKey(name,lastName);

        if (employeeMap.containsKey(keyEmployee)) {
            throw new EmployeeAlreadyAddedException("Добавляемый сотрудник уже имеется в списке");
        }

        employeeMap.put(keyEmployee, employee);
        return employee;
    }


    @Override
    public Employee removeEmployees(String name, String lastName) {
        Employee employee = employeeMap.remove(name + lastName);
        if (Objects.isNull(employee)) {
            throw new EmployeeNotFoundException("Удаляемый сотрудник не найден");
        }
        return employee;//Работает, потому что переопределили метод equals(), так как он сравнивает по name и lastname
    }

    @Override
    public Employee findEmployee(String name, String lastName) {
        Employee employee = employeeMap.get(name + lastName);
        if (Objects.isNull(employee)) {
            throw new EmployeeNotFoundException("Cотрудник не найден");
        }
        return employee;
    }

    @Override
    public Collection<Employee> findAllEmployee() {
        return Collections.unmodifiableCollection(employeeMap.values());
    }

    private String generateKey(String name, String lastName) {
        return name + lastName;
    }
}
