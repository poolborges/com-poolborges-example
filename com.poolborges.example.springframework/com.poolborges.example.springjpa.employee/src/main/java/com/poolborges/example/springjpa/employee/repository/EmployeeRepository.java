package com.poolborges.example.springjpa.employee.repository;

import com.poolborges.example.springjpa.employee.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Borges
 */
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
    
}
