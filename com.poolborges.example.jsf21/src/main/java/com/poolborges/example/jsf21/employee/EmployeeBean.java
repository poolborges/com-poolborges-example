package com.poolborges.example.jsf21.employee;

/**
 *
 * @author Borges
 */
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class EmployeeBean {

    private EmployeeService employeeService = new EmployeeService();

    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }
}
