package pro.sky.java.course2.EmployeeSpring.dto;

import java.util.Objects;

public class Employee {
    private final String lastName;
    private final String name;
    private final double salary;
    private final int department;


    public Employee(String name, String lastName, double salary, int department) {
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return
                "ФИО " + getLastname()
                        + " " + getName();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;
        Employee employee = (Employee) other;
        return Objects.equals(lastName, employee.lastName) && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, name);
    }
}
