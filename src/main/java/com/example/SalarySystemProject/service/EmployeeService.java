package com.example.SalarySystemProject.service;

import com.example.SalarySystemProject.entity.Employee;
import com.example.SalarySystemProject.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(String employeeId){
        return employeeRepository.findById(employeeId);
    }

    public Employee saveEmployee(@Valid Employee employee){
        // এখানে ভ্যালিডেশন বা অতিরিক্ত লজিক দিতে পারো
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(@Valid Employee employee){
        if(employeeRepository.existsById(employee.getEmployeeId())){
            return employeeRepository.save(employee);
        }
        throw new RuntimeException("Employee not found with ID: " + employee.getEmployeeId());
    }

    public void deleteEmployee(String employeeId){
        if(employeeRepository.existsById(employeeId)){
            employeeRepository.deleteById(employeeId);
        } else {
            throw new RuntimeException("Employee not found with ID: " + employeeId);
        }
    }
}
