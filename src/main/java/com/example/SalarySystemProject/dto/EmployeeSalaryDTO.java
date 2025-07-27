package com.example.SalarySystemProject.dto;

public class EmployeeSalaryDTO {
    private String employeeId;
    private String name;
    private int grade;
    private Double totalSalary;

    public EmployeeSalaryDTO(String employeeId, String name, int grade, Double totalSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.grade = grade;
        this.totalSalary = totalSalary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(Double totalSalary) {
        this.totalSalary = totalSalary;
    }
}
