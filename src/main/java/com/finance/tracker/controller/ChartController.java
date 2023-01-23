package com.finance.tracker.controller;

import com.finance.tracker.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/charts")
public class ChartController {

    @Autowired
    private ChartService chartService;

    @GetMapping("/income-expense")
    public Map<String, Object> generateIncomeExpenseChart() {
        return chartService.generateIncomeExpenseChart();
    }
}
