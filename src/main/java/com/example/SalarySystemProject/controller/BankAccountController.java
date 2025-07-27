package com.example.SalarySystemProject.controller;

import com.example.SalarySystemProject.dto.BankAccountDTO;
import com.example.SalarySystemProject.entity.BankAccount;
import com.example.SalarySystemProject.service.BankAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank-accounts")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping
    public List<BankAccount> getAll() {
        return bankAccountService.getAllBankAccounts();
    }

    @GetMapping("/{id}")
    public BankAccount getById(@PathVariable Long id) {
        return bankAccountService.getBankAccountById(id)
                .orElseThrow(() -> new RuntimeException("Bank account not found"));
    }

    @PostMapping
    public BankAccount create(@Valid @RequestBody BankAccountDTO dto) {
        BankAccount account = new BankAccount();
        account.setAccountType(dto.getAccountType());
        account.setAccountName(dto.getAccountName());
        account.setAccountNumber(dto.getAccountNumber());
        account.setCurrentBalance(dto.getCurrentBalance());
        account.setBankName(dto.getBankName());
        account.setBranchName(dto.getBranchName());
        return bankAccountService.saveBankAccount(account);
    }

    @PutMapping("/{id}")
    public BankAccount update(@PathVariable Long id, @Valid @RequestBody BankAccountDTO dto) {
        BankAccount updated = new BankAccount();
        updated.setAccountType(dto.getAccountType());
        updated.setAccountName(dto.getAccountName());
        updated.setAccountNumber(dto.getAccountNumber());
        updated.setCurrentBalance(dto.getCurrentBalance());
        updated.setBankName(dto.getBankName());
        updated.setBranchName(dto.getBranchName());
        return bankAccountService.updateBankAccount(id, updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            bankAccountService.deleteBankAccount(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

}
