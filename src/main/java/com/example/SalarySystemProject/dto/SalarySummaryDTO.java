package com.example.SalarySystemProject.dto;

public class SalarySummaryDTO {

    private Double totalSalaryPaid;
    private Double remainingCompanyBalance;

    public SalarySummaryDTO(Double totalSalaryPaid, Double remainingCompanyBalance) {
        this.totalSalaryPaid = totalSalaryPaid;
        this.remainingCompanyBalance = remainingCompanyBalance;
    }

    public Double getTotalSalaryPaid() {
        return totalSalaryPaid;
    }

    public void setTotalSalaryPaid(Double totalSalaryPaid) {
        this.totalSalaryPaid = totalSalaryPaid;
    }

    public Double getRemainingCompanyBalance() {
        return remainingCompanyBalance;
    }

    public void setRemainingCompanyBalance(Double remainingCompanyBalance) {
        this.remainingCompanyBalance = remainingCompanyBalance;
    }
}
