package com.example.SalarySystemProject.dto;

public class SalaryInputDTO {
    private String employeeId;
    private double lowestGradeSalary;

    public SalaryInputDTO() {}

    public SalaryInputDTO(String employeeId, double lowestGradeSalary) {
        this.employeeId = employeeId;
        this.lowestGradeSalary = lowestGradeSalary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public double getLowestGradeSalary() {
        return lowestGradeSalary;
    }

    public void setLowestGradeSalary(double lowestGradeSalary) {
        this.lowestGradeSalary = lowestGradeSalary;
    }
}
