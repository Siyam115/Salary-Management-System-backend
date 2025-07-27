package com.example.SalarySystemProject.service;

import com.example.SalarySystemProject.dto.SalarySheetDTO;
import com.example.SalarySystemProject.dto.SalarySummaryDTO;
import com.example.SalarySystemProject.dto.SalaryTransactionDTO;
import com.example.SalarySystemProject.entity.*;
import com.example.SalarySystemProject.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SalaryTransactionService {

    @Autowired
    private SalaryTransactionRepository salaryTransactionRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private CompanyAccountRepository companyAccountRepository;

    /**
     * Salary calculation and transaction
     */
    @Transactional
    public SalaryTransaction processSalary(String employeeId, double lowestGradeSalary) {

        // 1. Get employee
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // 2. Calculate Basic Salary based on Grade
        int grade = employee.getGrade(); // Grade 6 = lowest
        double gradeDifference = 6 - grade;
        double basicSalary = lowestGradeSalary + (gradeDifference * 5000);
        double houseRent = basicSalary * 0.20;
        double medicalAllowance = basicSalary * 0.15;
        double totalSalary = basicSalary + houseRent + medicalAllowance;

        if (totalSalary <= 0) {
            throw new RuntimeException("Total Salary must be greater than zero");
        }

        // 3. Get Company Account
        CompanyAccount companyAccount = companyAccountRepository.findAll().stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Company account not found"));

        // Safe check for null balance
        if (companyAccount.getCurrentBalance() == null) {
            companyAccount.setCurrentBalance(0.0);
        }

        // 4. Get Employee's Bank Account
        BankAccount employeeBank = bankAccountRepository.findById(employee.getBankAccount().getId())
                .orElseThrow(() -> new RuntimeException("Employee bank account not found"));

        // Safe check for null balance
        if (employeeBank.getCurrentBalance() == null) {
            employeeBank.setCurrentBalance(0.0);
        }

        // 5. Transfer Salary
        if (companyAccount.getCurrentBalance() < totalSalary) {
            throw new RuntimeException("Not enough balance in company account.");
        }

        companyAccount.setCurrentBalance(companyAccount.getCurrentBalance() - totalSalary);
        employeeBank.setCurrentBalance(employeeBank.getCurrentBalance() + totalSalary);

        // 6. Save updated balances
        companyAccountRepository.save(companyAccount);
        bankAccountRepository.save(employeeBank);

        // 7. Set salary transaction details
        SalaryTransaction transaction = new SalaryTransaction();
        transaction.setEmployee(employee);
        transaction.setBasicSalary(basicSalary);
        transaction.setHouseRent(houseRent);
        transaction.setMedicalAllowance(medicalAllowance);
        transaction.setTotalSalary(totalSalary);
        transaction.setStatus("PAID");
        transaction.setPaymentDate(LocalDate.now());

        // 8. Save and return transaction
        return salaryTransactionRepository.save(transaction);
    }

    // সব salary transaction নিয়ে আসার মেথড
    public List<SalaryTransaction> getAllTransactions() {
        return salaryTransactionRepository.findAll();
    }

    // ID অনুসারে salary transaction পাওয়ার মেথড
    public SalaryTransaction getTransactionById(Long id) {
        return salaryTransactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with ID: " + id));
    }

    public void deleteTransaction(Long id) {
        if (salaryTransactionRepository.existsById(id)) {
            salaryTransactionRepository.deleteById(id);
        } else {
            throw new RuntimeException("Transaction not found with ID: " + id);
        }
    }

    public List<SalarySheetDTO> getSalarySheet() {
        List<SalaryTransaction> transactions = salaryTransactionRepository.findAll();

        return transactions.stream().map(tx ->
                new SalarySheetDTO(
                        tx.getEmployee().getName(),
                        tx.getEmployee().getGrade(),
                        tx.getTotalSalary()
                )
        ).toList();
    }

    public SalarySummaryDTO getSalarySummary() {
        List<SalaryTransaction> transactions = salaryTransactionRepository.findAll();

        double totalPaid = transactions.stream()
                .mapToDouble(SalaryTransaction::getTotalSalary)
                .sum();

        CompanyAccount companyAccount = companyAccountRepository.findAll().stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Company account not found"));

        // এখানে currentBalance null safe set করো
        double currentBalance = companyAccount.getCurrentBalance() == null ? 0.0 : companyAccount.getCurrentBalance();

        return new SalarySummaryDTO(totalPaid, currentBalance);
    }
}