package com.example.Billing.Service.repository;

import com.example.Billing.Service.model.BillingRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingRepository extends MongoRepository<BillingRecord, String> {
    List<BillingRecord> findByMeterId(String meterId);
}