package com.example.SalarySystemProject.dto;

public class SalaryTransactionDTO {

    private Long id;
    private String employeeId;
    private String employeeName;
    private Double amount;
    private String transactionDate;

    // Constructors
    public SalaryTransactionDTO() {}

    public SalaryTransactionDTO(Long id, String employeeId, String employeeName, Double amount, String transactionDate) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.id = id;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
}
