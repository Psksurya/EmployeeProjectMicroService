package com.surya.dev.employee_service.service;

import com.surya.dev.employee_service.dto.APIResponseDto;
import com.surya.dev.employee_service.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto departmentDto);
    APIResponseDto getEmployeeById(Long employeeId);



}
