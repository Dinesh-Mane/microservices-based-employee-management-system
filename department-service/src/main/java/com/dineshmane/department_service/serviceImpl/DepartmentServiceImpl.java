package com.dineshmane.department_service.serviceImpl;

import com.dineshmane.department_service.dto.DepartmentDto;
import com.dineshmane.department_service.entity.Department;
import com.dineshmane.department_service.repository.DepartmentRepository;
import com.dineshmane.department_service.service.DepartmentService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentDescription(departmentDto.getDepartmentDescription());
        department.setDepartmentCode(departmentDto.getDepartmentCode());
        Department saved = departmentRepository.save(department);
        return new DepartmentDto(saved.getId(), saved.getDepartmentName(), saved.getDepartmentDescription(), saved.getDepartmentCode());
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository.findByDepartmentCode(code).get();
        return new DepartmentDto(department.getId(), department.getDepartmentName(), department.getDepartmentDescription(),department.getDepartmentCode());
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> allDept = departmentRepository.findAll();
        return allDept.stream()
                .map(d-> new DepartmentDto(d.getId(), d.getDepartmentName(), d.getDepartmentDescription(), d.getDepartmentCode()))
                .toList();
    }

    @Override
    public DepartmentDto updatedDepartment(DepartmentDto departmentDto) {
        Department d = departmentRepository.findByDepartmentCode(departmentDto.getDepartmentCode()).get();
        d.setDepartmentName(departmentDto.getDepartmentName());
        d.setDepartmentDescription(departmentDto.getDepartmentDescription());
        Department saved = departmentRepository.save(d);
        return new DepartmentDto(saved.getId(), saved.getDepartmentName(), saved.getDepartmentDescription(), saved.getDepartmentCode());
    }

    @Override
    @Transactional
    public void deleteDepartmentByCode(String code) {
        departmentRepository.deleteByDepartmentCode(code);
    }
}
