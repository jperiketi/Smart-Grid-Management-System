package com.example.Billing.Service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;  // Use @Table for Cassandra

import java.time.LocalDateTime;

@Document(collection = "billing_records")  // or @Table for Cassandra
public class BillingRecord {
    @Id
    private String id;
    private String meterId;
    private double amount;
    private LocalDateTime billingDate;

    public void setMeterId(String meterId) {
    }

    public void setAmount(double billingAmount) {
    }

    public void setBillingDate(LocalDateTime now) {
    }

    // Getters and Setters
}