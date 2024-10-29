package com.example.Billing.Service.service;

import com.example.Billing.Service.model.BillingRecord;
import com.example.Billing.Service.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.example.Billing.Service.model.MeterReading;

import java.time.LocalDateTime;

@Service
public class BillingService {

    private final BillingRepository billingRepository;

    @Autowired
    public BillingService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    @KafkaListener(topics = "meter-readings-topic", groupId = "billing-group")
    public void consumeMeterReading(MeterReading meterReading) {
        double ratePerUnit = 0.15;  // Example billing logic
        double billingAmount = meterReading.getReading() * ratePerUnit;

        BillingRecord billingRecord = new BillingRecord();
        billingRecord.setMeterId(meterReading.getMeterId());
        billingRecord.setAmount(billingAmount);
        billingRecord.setBillingDate(LocalDateTime.now());

        billingRepository.save(billingRecord);
    }
}