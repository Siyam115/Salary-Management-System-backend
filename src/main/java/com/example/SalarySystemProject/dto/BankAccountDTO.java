package com.example.SalarySystemProject.dto;

public class BankAccountDTO {

    private String accountType;
    private String accountName;
    private String accountNumber;
    private Double currentBalance;
    private String bankName;
    private String branchName;

    // Constructors
    public BankAccountDTO() {}

    public BankAccountDTO(String accountType, String accountName, String accountNumber,
                          Double currentBalance, String bankName, String branchName) {
        this.accountType = accountType;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.bankName = bankName;
        this.branchName = branchName;
    }

    // Getters and Setters

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
