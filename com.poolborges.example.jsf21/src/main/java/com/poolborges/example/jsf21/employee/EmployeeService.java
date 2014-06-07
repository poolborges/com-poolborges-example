package com.poolborges.example.jsf21.employee;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Borges
 */
public class EmployeeService {

    private List<Employee> employees = new ArrayList<Employee>();

    public EmployeeService() {
        employees.add(new Employee("1", "Borges", "Management"));
        employees.add(new Employee("2", "Jorge", "Management"));
        employees.add(new Employee("3", "Andrea", "Sales"));
        employees.add(new Employee("4", "Dani", "Sales"));
        employees.add(new Employee("5", "Victor", "Sales"));
        employees.add(new Employee("6", "Aricson", "HR"));
        employees.add(new Employee("7", "Hugo", "Comercial"));
        employees.add(new Employee("8", "Carlos", "Support"));
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }
}
