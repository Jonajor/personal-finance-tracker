package com.finance.tracker.service;

import com.finance.tracker.model.Income;
import com.finance.tracker.repository.CategoryRepository;
import com.finance.tracker.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeService {
    private IncomeRepository incomeRepository;

    private CategoryRepository categoryRepository;

    @Autowired
    public IncomeService(IncomeRepository incomeRepository, CategoryRepository categoryRepository) {
        this.incomeRepository = incomeRepository;
        this.categoryRepository = categoryRepository;
    }

    public Income createIncome(Income income) {
        // check if the category exists
        if (categoryRepository.findById(income.getCategory().getId()).isPresent()) {
            return incomeRepository.save(income);
        } else {
            throw new RuntimeException("Category not found");
        }
    }

    public List<Income> getAllIncomes() {
        return incomeRepository.findAll();
    }

    public Optional<Income> getIncomeById(Long id) {
        return incomeRepository.findById(id);
    }

    public Income updateIncome(Long id, Income income) {
        // check if the income exists
        if (incomeRepository.findById(id).isPresent()) {
            // check if the category exists
            if (categoryRepository.findById(income.getCategory().getId()).isPresent()) {
                income.setId(id);
                return incomeRepository.save(income);
            } else {
                throw new RuntimeException("Category not found");
            }
        } else {
            throw new RuntimeException("Income not found");
        }
    }

    public void deleteIncome(Long id) {
        incomeRepository.deleteById(id);
    }
}
