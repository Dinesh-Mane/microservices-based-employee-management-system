package com.dineshmane.employee_service.service;

import com.dineshmane.employee_service.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE", url = "http://localhost:8080")
public interface APIClient {

    @GetMapping("/api/departments/{code}")
    DepartmentDto getDepartment(@PathVariable("code") String code);
}
