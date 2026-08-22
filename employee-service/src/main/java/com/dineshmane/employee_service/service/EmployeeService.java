package com.dineshmane.employee_service.service;

import com.dineshmane.employee_service.dto.APIResponseDto;
import com.dineshmane.employee_service.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long id);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(EmployeeDto employeeDto);
    void deleteEmployeeById(Long id);

}
