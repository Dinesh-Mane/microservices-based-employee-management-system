package com.dineshmane.department_service.controller;

import com.dineshmane.department_service.dto.DepartmentDto;
import com.dineshmane.department_service.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto department = departmentService.createDepartment(departmentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(department);
    }

    @GetMapping("/{deptCode}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("deptCode") String code){
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(code);
        return ResponseEntity.status(HttpStatus.OK).body(departmentDto);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.getAllDepartments());
    }

    @PutMapping("/{deptCode}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("deptCode") String code, @RequestBody DepartmentDto departmentDto){
        departmentDto.setDepartmentCode(code);
        DepartmentDto updatedDepartmentDto = departmentService.updatedDepartment(departmentDto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedDepartmentDto);
    }

    @DeleteMapping("/{deptCode}")
    public ResponseEntity<String> deleteDepartmentByCode(@PathVariable("deptCode") String code){
        departmentService.deleteDepartmentByCode(code);
        return ResponseEntity.status(HttpStatus.OK).body("Department Deleted");
    }

}
