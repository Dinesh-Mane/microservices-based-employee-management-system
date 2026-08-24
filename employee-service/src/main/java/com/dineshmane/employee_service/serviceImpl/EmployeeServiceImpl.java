package com.dineshmane.employee_service.serviceImpl;

import com.dineshmane.employee_service.dto.APIResponseDto;
import com.dineshmane.employee_service.dto.DepartmentDto;
import com.dineshmane.employee_service.dto.EmployeeDto;
import com.dineshmane.employee_service.entity.Employee;
import com.dineshmane.employee_service.repository.EmployeeRepository;
import com.dineshmane.employee_service.service.APIClient;
import com.dineshmane.employee_service.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
//    private RestTemplate restTemplate;
//    private WebClient webClient;
    private APIClient apiClient;

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
    @CircuitBreaker(name = "employee-service", fallbackMethod = "getDefaultDepartment")
    public APIResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();

        // REST API call using RestTemplate
//        ResponseEntity<DepartmentDto> response = restTemplate.getForEntity(
//                "http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
//                DepartmentDto.class
//        );
//        DepartmentDto departmentDto = response.getBody();

        // REST API call using WebClient
//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();  // for synchronous calling

        // REST API call using Feign client
        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
        EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getDepartmentCode());
        return new APIResponseDto(employeeDto,departmentDto);
    }

    // fallback method
    public APIResponseDto getDefaultDepartment(Long id, Throwable throwable) {
        DepartmentDto defaultDepartmentDto = new DepartmentDto();
        defaultDepartmentDto.setDepartmentName("R&D Department");
        defaultDepartmentDto.setDepartmentCode("R&D001");
        defaultDepartmentDto.setDepartmentDescription("Research and Development");

        Employee employee = employeeRepository.findById(id).get();
        EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getDepartmentCode());
        return new APIResponseDto(employeeDto,defaultDepartmentDto);
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
