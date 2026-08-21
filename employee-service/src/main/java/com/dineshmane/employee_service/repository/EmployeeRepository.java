package com.dineshmane.employee_service.repository;

import com.dineshmane.employee_service.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findById(Long id);
    void deleteById(Long id);
}
