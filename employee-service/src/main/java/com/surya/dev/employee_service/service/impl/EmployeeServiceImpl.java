package com.surya.dev.employee_service.service.impl;


import com.surya.dev.employee_service.dto.APIResponseDto;
import com.surya.dev.employee_service.dto.DepartmentDto;
import com.surya.dev.employee_service.dto.EmployeeDto;
import com.surya.dev.employee_service.entity.Employee;
import com.surya.dev.employee_service.repository.EmployeeRepository;
import com.surya.dev.employee_service.service.APIClient;
import com.surya.dev.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
//    private final RestTemplate restTemplate;
//private WebClient webClient;
  private final APIClient apiClient;

    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmailId(),
                employeeDto.getDepartmentCode()
        );
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmailId(),
                savedEmployee.getDepartmentCode()
        );

        return savedEmployeeDto;

    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).get();
//       ResponseEntity<DepartmentDto>responseEntity= restTemplate.getForEntity(
//                "http://localhost:8080/api/departments/"+employee.getDepartmentCode(),
//                DepartmentDto.class);
//
//       DepartmentDto departmentDto= responseEntity.getBody();

//        DepartmentDto departmentDto = webClient.get().uri(
//                "http://localhost:8080/api/departments/"+employee.getDepartmentCode()).
//                retrieve().bodyToMono(DepartmentDto.class).block();
DepartmentDto departmentDto =apiClient.getDepartment(employee.getDepartmentCode());

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmailId(),
                employee.getDepartmentCode()
        );

        APIResponseDto apiResponseDto= new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;
    }

}
