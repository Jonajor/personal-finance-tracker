package com.finance.tracker.repository;

import com.finance.tracker.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IncomeRepository extends JpaRepository<Income, Long> {

    @Query("SELECT SUM(i.amount) FROM Income i")
    Double getSumOfAmount();

    @Query("SELECT i.category, SUM(i.amount) FROM Income i GROUP BY i.category")
    List<Object[]> findAllGroupByCategory();

    List<Income> findAllByCategoryId(Long id);
}