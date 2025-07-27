package com.example.SalarySystemProject.repository;

import com.example.SalarySystemProject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    // EmployeeId হচ্ছে String (4-digit id)
}
