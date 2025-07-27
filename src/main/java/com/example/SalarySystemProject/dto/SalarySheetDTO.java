package com.example.SalarySystemProject.dto;

public class SalarySheetDTO {
    private String employeeName;
    private int grade;
    private double totalSalary;

    public SalarySheetDTO(String employeeName, int grade, double totalSalary) {
        this.employeeName = employeeName;
        this.grade = grade;
        this.totalSalary = totalSalary;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }
}
