package com.example.SalarySystemProject.service;

import com.example.SalarySystemProject.entity.CompanyAccount;
import com.example.SalarySystemProject.repository.CompanyAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyAccountService {

    @Autowired
    private CompanyAccountRepository companyAccountRepository;

    public CompanyAccount initializeCompanyAccount(CompanyAccount account) {
        return companyAccountRepository.save(account);
    }

    public CompanyAccount getCompanyAccount() {
        Optional<CompanyAccount> account = companyAccountRepository.findAll().stream().findFirst();
        return account.orElse(null);
    }

    public CompanyAccount addFunds(Double amount) {
        CompanyAccount account = getCompanyAccount();
        if (account == null) {
            throw new RuntimeException("Company account not found!");
        }
        double newBalance = account.getCurrentBalance() + amount;
        account.setCurrentBalance(newBalance);
        return companyAccountRepository.save(account);
    }

    public List<CompanyAccount> getAllCompanyAccounts() {
        return companyAccountRepository.findAll();
    }

    public CompanyAccount updateCompanyAccount(Long id, CompanyAccount updatedAccount) {
        Optional<CompanyAccount> optionalAccount = companyAccountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            CompanyAccount existingAccount = optionalAccount.get();
            existingAccount.setAccountType(updatedAccount.getAccountType());
            existingAccount.setAccountName(updatedAccount.getAccountName());
            existingAccount.setAccountNumber(updatedAccount.getAccountNumber());
            existingAccount.setCurrentBalance(updatedAccount.getCurrentBalance());
            existingAccount.setBankName(updatedAccount.getBankName());
            existingAccount.setBranchName(updatedAccount.getBranchName());
            return companyAccountRepository.save(existingAccount);
        } else {
            return null;
        }
    }

    public boolean deleteCompanyAccount(Long id) {
        if (companyAccountRepository.existsById(id)) {
            companyAccountRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<CompanyAccount> findById(Long id) {
        return companyAccountRepository.findById(id);
    }
}
