package com.finance.tracker.service;

import com.finance.tracker.model.Expense;
import com.finance.tracker.model.Income;
import com.finance.tracker.repository.ExpenseRepository;
import com.finance.tracker.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    private final IncomeRepository incomeRepository;

    private final ExpenseRepository expenseRepository;

    @Autowired
    public ReportService(IncomeRepository incomeRepository, ExpenseRepository expenseRepository) {
        this.incomeRepository = incomeRepository;
        this.expenseRepository = expenseRepository;
    }

    public Map<String, Object> generateIncomeExpenseReport() {
        Map<String, Object> report = new HashMap<>();
        report.put("totalIncome", incomeRepository.getSumOfAmount());
        report.put("totalExpense", expenseRepository.getSumOfAmount());
        return report;
    }

    public Map<String, Object> generateCategoryReport(Long id) {
        Map<String, Object> report = new HashMap<>();

        List<Income> incomes = incomeRepository.findAllByCategoryId(id);
        List<Expense> expenses = expenseRepository.findAllByCategoryId(id);

        BigDecimal totalIncome = BigDecimal.ZERO;
        for (Income income : incomes) {
            totalIncome = totalIncome.add(income.getAmount());
        }

        BigDecimal totalExpense = BigDecimal.ZERO;
        for (Expense expense : expenses) {
            totalExpense = totalExpense.add(expense.getAmount());
        }

        report.put("categoryName", incomes.get(0).getCategory().getName());
        report.put("totalIncome", totalIncome);
        report.put("totalExpense", totalExpense);
        report.put("balance", totalIncome.subtract(totalExpense));

        return report;
    }

}