package com.poolborges.example.springjpa.employee.repository;

import com.poolborges.example.springjpa.employee.domain.Employee;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Borges
 */
public class EmployeeRepositoryTest extends AbstractRepositoryTest{
   
    private Employee employee;
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Before
    public void setUp() {

        employee = new Employee ();
        employee.setName("Siyaphambili");
        employee.setType("High");
        employee.setEmis("Something");
        employee.setTelephone("039 433 5555");
        employee.setFax("039 433 5551");
        employee.setAddress("Pisgah, KwaMachi, Harding");
    }
    @Test
    public void saveNewEmployee () {
        Employee newEmployee  = employeeRepository.save(employee);
        assertTrue("There must be a employee now", newEmployee  != null);
    }
}
