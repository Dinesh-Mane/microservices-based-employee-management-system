package com.dineshmane.department_service.service.impl;

import com.dineshmane.department_service.repository.DepartmentRepository;
import com.dineshmane.department_service.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

}
