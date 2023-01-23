package com.finance.tracker.service;

import com.finance.tracker.model.Expense;
import com.finance.tracker.repository.CategoryRepository;
import com.finance.tracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    private CategoryRepository categoryRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository, CategoryRepository categoryRepository) {
        this.expenseRepository = expenseRepository;
        this.categoryRepository = categoryRepository;
    }

    public Expense createExpense(Expense expense) {
        // check if the category exists
        if (categoryRepository.findById(expense.getCategory().getId()).isPresent()) {
            return expenseRepository.save(expense);
        } else {
            throw new RuntimeException("Category not found");
        }
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    public Expense updateExpense(Long id, Expense expense) {
        // check if the expense exists
        if (expenseRepository.findById(id).isPresent()) {
            // check if the category exists
            if (categoryRepository.findById(expense.getCategory().getId()).isPresent()) {
                expense.setId(id);
                return expenseRepository.save(expense);
            } else {
                throw new RuntimeException("Category not found");
            }
        } else {
            throw new RuntimeException("Expense not found");
        }
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
