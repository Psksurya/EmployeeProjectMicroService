package com.surya.dev.employee_service.repository;

import com.surya.dev.employee_service.dto.EmployeeDto;
import com.surya.dev.employee_service.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
