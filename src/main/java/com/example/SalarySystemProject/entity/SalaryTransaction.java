package com.example.SalarySystemProject.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "salary_transaction")
public class SalaryTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double basicSalary;
    private double houseRent;
    private double medicalAllowance;
    private double totalSalary;
    private String status;
    private LocalDate paymentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // --- Getters and Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getHouseRent() {
        return houseRent;
    }

    public void setHouseRent(double houseRent) {
        this.houseRent = houseRent;
    }

    public double getMedicalAllowance() {
        return medicalAllowance;
    }

    public void setMedicalAllowance(double medicalAllowance) {
        this.medicalAllowance = medicalAllowance;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
