package com.example.SalarySystemProject.service;

import com.example.SalarySystemProject.entity.BankAccount;
import com.example.SalarySystemProject.repository.BankAccountRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }

    public Optional<BankAccount> getBankAccountById(Long id) {
        return bankAccountRepository.findById(id);
    }

    public BankAccount saveBankAccount(@Valid BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    public BankAccount updateBankAccount(Long id, @Valid BankAccount updatedAccount) {
        Optional<BankAccount> existing = bankAccountRepository.findById(id);
        if (existing.isPresent()) {
            BankAccount bankAccount = existing.get();
            bankAccount.setAccountName(updatedAccount.getAccountName());
            bankAccount.setAccountNumber(updatedAccount.getAccountNumber());
            bankAccount.setAccountType(updatedAccount.getAccountType());
            bankAccount.setCurrentBalance(updatedAccount.getCurrentBalance());
            bankAccount.setBankName(updatedAccount.getBankName());
            bankAccount.setBranchName(updatedAccount.getBranchName());
            return bankAccountRepository.save(bankAccount);
        } else {
            throw new RuntimeException("Bank account not found with ID: " + id);
        }
    }

    public void deleteBankAccount(Long id) {
        if (bankAccountRepository.existsById(id)) {
            bankAccountRepository.deleteById(id);
        } else {
            throw new RuntimeException("Bank account not found with ID: " + id);
        }
    }
}
