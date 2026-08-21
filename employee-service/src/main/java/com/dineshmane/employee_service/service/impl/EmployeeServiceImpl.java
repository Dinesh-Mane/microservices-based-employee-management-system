package com.dineshmane.employee_service.service.impl;

import com.dineshmane.employee_service.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl {

    private EmployeeRepository employeeRepository;

}
