package com.finance.tracker.controller;

import com.finance.tracker.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/income-expense")
    public Map<String, Object> generateIncomeExpenseReport() {
        return reportService.generateIncomeExpenseReport();
    }

    @GetMapping("/category/{id}")
    public Map<String, Object> generateCategoryReport(@PathVariable Long id) {
        return reportService.generateCategoryReport(id);
    }
}
