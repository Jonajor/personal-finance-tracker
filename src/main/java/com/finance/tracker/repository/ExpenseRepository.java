package com.finance.tracker.repository;

import com.finance.tracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    @Query(value = "SELECT SUM(amount) FROM expense", nativeQuery = true)
    Double getSumOfAmount();

    @Query("SELECT e.category, SUM(e.amount) FROM Expense e GROUP BY e.category")
    List<Object[]> findAllGroupByCategory();

    List<Expense> findAllByCategoryId(Long id);
}