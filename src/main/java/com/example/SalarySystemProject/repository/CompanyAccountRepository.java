package com.example.SalarySystemProject.repository;

import com.example.SalarySystemProject.entity.CompanyAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyAccountRepository extends JpaRepository<CompanyAccount, Long> {
    // দরকার হলে কাস্টম মেথড এখানে যোগ করতে পারো
}
