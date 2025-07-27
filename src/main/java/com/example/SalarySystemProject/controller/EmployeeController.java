package com.example.SalarySystemProject.controller;

import com.example.SalarySystemProject.entity.Employee;
import com.example.SalarySystemProject.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get employee by ID
    @GetMapping("/{employeeId}")
    public Optional<Employee> getEmployeeById(@PathVariable String employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    // Create employee
    @PostMapping
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    // Update employee
    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@PathVariable String employeeId, @Valid @RequestBody Employee employee) {
        if (!employeeId.equals(employee.getEmployeeId())) {
            throw new RuntimeException("Employee ID in path and body do not match.");
        }
        return employeeService.updateEmployee(employee);
    }

    // Delete employee
    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable String employeeId) {
        employeeService.deleteEmployee(employeeId);
    }
}
