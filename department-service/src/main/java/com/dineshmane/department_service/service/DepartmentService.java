package com.dineshmane.department_service.service;

import com.dineshmane.department_service.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentByCode(String code);
    List<DepartmentDto> getAllDepartments();
    DepartmentDto updatedDepartment(DepartmentDto departmentDto);
    void deleteDepartmentByCode(String code);
}
