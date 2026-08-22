package com.dineshmane.employee_service.service.impl;

import com.dineshmane.employee_service.dto.EmployeeDto;
import com.dineshmane.employee_service.entity.Employee;
import com.dineshmane.employee_service.repository.EmployeeRepository;
import com.dineshmane.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setDepartmentCode(employeeDto.getDepartmentCode());


        Employee savedEmp = employeeRepository.save(employee);
        return new EmployeeDto(savedEmp.getId(), savedEmp.getFirstName(), savedEmp.getLastName(), savedEmp.getEmail(), savedEmp.getDepartmentCode());
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getDepartmentCode());
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> allEmp = employeeRepository.findAll();
        return allEmp.stream()
                .map(e -> new EmployeeDto(e.getId(), e.getFirstName(), e.getLastName(), e.getEmail(), e.getDepartmentCode()))
                .toList();
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(employeeDto.getId()).get();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setDepartmentCode(employeeDto.getDepartmentCode());
        Employee updatedEmp = employeeRepository.save(employee);
        return new EmployeeDto(updatedEmp.getId(), updatedEmp.getFirstName(), updatedEmp.getLastName(), updatedEmp.getEmail(), updatedEmp.getDepartmentCode());
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}
