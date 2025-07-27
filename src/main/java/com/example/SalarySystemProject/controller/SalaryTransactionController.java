package com.example.SalarySystemProject.controller;

import com.example.SalarySystemProject.dto.SalaryInputDTO;
import com.example.SalarySystemProject.dto.SalarySheetDTO;
import com.example.SalarySystemProject.dto.SalarySummaryDTO;
import com.example.SalarySystemProject.dto.SalaryTransactionDTO;
import com.example.SalarySystemProject.entity.CompanyAccount;
import com.example.SalarySystemProject.entity.SalaryTransaction;
import com.example.SalarySystemProject.service.SalaryTransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/salary-transactions")
public class SalaryTransactionController {

    @Autowired
    private SalaryTransactionService salaryTransactionService;

    // Get all salary transactions
    @GetMapping
    public ResponseEntity<List<SalaryTransactionDTO>> getAllTransactions() {
        List<SalaryTransaction> transactions = salaryTransactionService.getAllTransactions();

        List<SalaryTransactionDTO> dtos = transactions.stream().map(tx -> {
            SalaryTransactionDTO dto = new SalaryTransactionDTO();
            dto.setEmployeeId(tx.getEmployee().getEmployeeId());
            dto.setEmployeeName(tx.getEmployee().getName());
            dto.setAmount(tx.getTotalSalary());
            dto.setTransactionDate(tx.getPaymentDate().toString());
            return dto;
        }).toList();

        return ResponseEntity.ok(dtos);
    }
    // Get transaction by ID
    @GetMapping("/{id}")
    public ResponseEntity<SalaryTransactionDTO> getTransactionById(@PathVariable Long id) {
        SalaryTransaction tx = salaryTransactionService.getTransactionById(id);

        SalaryTransactionDTO dto = new SalaryTransactionDTO();
        dto.setId(tx.getId());
        dto.setEmployeeId(tx.getEmployee().getEmployeeId());
        dto.setEmployeeName(tx.getEmployee().getName());
        dto.setAmount(tx.getTotalSalary());
        dto.setTransactionDate(tx.getPaymentDate().toString());

        return ResponseEntity.ok(dto);
    }


    // Create a new salary transaction
    @PostMapping("/process")
    public ResponseEntity<SalaryTransaction> processSalary(
            @RequestParam String employeeId,
            @RequestParam double lowestGradeSalary) {

        SalaryTransaction transaction = salaryTransactionService.processSalary(employeeId, lowestGradeSalary);
        return ResponseEntity.ok(transaction);
    }





    // Delete transaction by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        salaryTransactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/sheet")
    public ResponseEntity<List<SalarySheetDTO>> getSalarySheet() {
        return ResponseEntity.ok(salaryTransactionService.getSalarySheet());
    }

    @GetMapping("/summary")
    public ResponseEntity<SalarySummaryDTO> getSalarySummary() {
        return ResponseEntity.ok(salaryTransactionService.getSalarySummary());
    }

}
