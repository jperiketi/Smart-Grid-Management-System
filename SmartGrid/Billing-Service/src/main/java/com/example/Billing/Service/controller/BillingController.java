package com.example.Billing.Service.controller;

import com.example.Billing.Service.model.BillingRecord;
import com.example.Billing.Service.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/billing")
public class BillingController {

    private final BillingRepository billingRepository;

    @Autowired
    public BillingController(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    @GetMapping("/{meterId}")
    public List<BillingRecord> getBillingRecords(@PathVariable String meterId) {
        return billingRepository.findByMeterId(meterId);
    }

    @GetMapping
    public List<BillingRecord> getAllBillingRecords() {
        return billingRepository.findAll();
    }
}