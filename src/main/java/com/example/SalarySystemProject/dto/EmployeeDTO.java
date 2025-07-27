package com.example.SalarySystemProject.dto;

public class EmployeeDTO {
    private String employeeId;
    private String name;
    private int grade;
    private String address;
    private String mobileNumber;
    private Long bankAccountId;

    // Constructors
    public EmployeeDTO() {}

    public EmployeeDTO(String employeeId, String name, int grade, String address, String mobileNumber, Long bankAccountId) {
        this.employeeId = employeeId;
        this.name = name;
        this.grade = grade;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.bankAccountId = bankAccountId;
    }

    // Getters and Setters

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Long getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Long bankAccountId) {
        this.bankAccountId = bankAccountId;
    }
}
