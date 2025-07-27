package com.example.SalarySystemProject.controller;

import com.example.SalarySystemProject.entity.CompanyAccount;
import com.example.SalarySystemProject.service.CompanyAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/company-accounts")
public class CompanyAccountController {

    private final CompanyAccountService companyAccountService;

    @Autowired
    public CompanyAccountController(CompanyAccountService companyAccountService) {
        this.companyAccountService = companyAccountService;
    }

    // Get all accounts
    @GetMapping("/all")
    public ResponseEntity<List<CompanyAccount>> getAllCompanyAccounts() {
        return ResponseEntity.ok(companyAccountService.getAllCompanyAccounts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CompanyAccount> getCompanyAccountById(@PathVariable Long id) {
        Optional<CompanyAccount> account = companyAccountService.findById(id);
        return account.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    // Create account
    @PostMapping
    public ResponseEntity<CompanyAccount> createCompanyAccount(@Valid @RequestBody CompanyAccount companyAccount) {
        CompanyAccount savedAccount = companyAccountService.initializeCompanyAccount(companyAccount);
        return ResponseEntity.ok(savedAccount);
    }

    // Update account by id
    @PutMapping("/{id}")
    public ResponseEntity<CompanyAccount> updateCompanyAccount(@PathVariable Long id,
                                                               @Valid @RequestBody CompanyAccount companyAccount) {
        CompanyAccount updatedAccount = companyAccountService.updateCompanyAccount(id, companyAccount);
        if (updatedAccount == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedAccount);
    }

    // Delete account by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanyAccount(@PathVariable Long id) {
        boolean deleted = companyAccountService.deleteCompanyAccount(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Add funds
    @PutMapping("/add-funds")
    public ResponseEntity<CompanyAccount> addFunds(@RequestParam Double amount) {
        if (amount == null || amount <= 0) {
            return ResponseEntity.badRequest().build();
        }
        CompanyAccount updatedAccount = companyAccountService.addFunds(amount);
        return ResponseEntity.ok(updatedAccount);
    }
}
