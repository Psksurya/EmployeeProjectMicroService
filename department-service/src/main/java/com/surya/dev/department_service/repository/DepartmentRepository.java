package com.surya.dev.department_service.repository;

import com.surya.dev.department_service.dto.DepartmentDto;
import com.surya.dev.department_service.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
Department findByDepartmentCode(String departmentCode);
}
