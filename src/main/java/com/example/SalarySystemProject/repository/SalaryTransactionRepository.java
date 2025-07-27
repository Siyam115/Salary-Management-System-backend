package com.example.SalarySystemProject.repository;

import com.example.SalarySystemProject.entity.SalaryTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryTransactionRepository extends JpaRepository<SalaryTransaction, Long> {
}
