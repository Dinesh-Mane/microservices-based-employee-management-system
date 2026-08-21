package com.dineshmane.employee_service.controller;

import com.dineshmane.employee_service.dto.EmployeeDto;
import com.dineshmane.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmpDto = employeeService.saveEmployee(employeeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmpDto);
    }

    @GetMapping("/{empId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("empId") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeById(id));
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployees());
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id,@RequestBody EmployeeDto employeeDto){
        employeeDto.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateEmployee(employeeDto));
    }

    @DeleteMapping("/{empId}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("empId") Long id){
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Employee deleted");
    }
}
