package com.dineshmane.employee_service.controller;

import com.dineshmane.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/departments/{id}/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

}
