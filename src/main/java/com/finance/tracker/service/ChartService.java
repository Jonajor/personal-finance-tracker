package com.finance.tracker.service;

import com.finance.tracker.model.Expense;
import com.finance.tracker.model.Income;
import com.finance.tracker.repository.ExpenseRepository;
import com.finance.tracker.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChartService {
    private ExpenseService expenseService;

    private IncomeService incomeService;

    public ChartService(ExpenseService expenseService, IncomeService incomeService) {
        this.expenseService = expenseService;
        this.incomeService = incomeService;
    }

    public Map<String, Object> generateIncomeExpenseChart() {
        Map<String, Object> data = new HashMap<>();
        List<Income> incomes = incomeService.getAllIncomes();
        List<Expense> expenses = expenseService.getAllExpenses();
        List<String> labels = new ArrayList<>();
        List<BigDecimal> incomeData = new ArrayList<>();
        List<BigDecimal> expenseData = new ArrayList<>();
        for (Income income : incomes) {
            labels.add(income.getDate().toString());
            incomeData.add(income.getAmount());
        }
        for (Expense expense : expenses) {
            if (!labels.contains(expense.getDate().toString())) {
                labels.add(expense.getDate().toString());
            }
            expenseData.add(expense.getAmount());
        }
        data.put("labels", labels);
        data.put("incomeData", incomeData);
        data.put("expenseData", expenseData);
        return data;
    }
}
