package com.example.Billing.Service.model;



import java.time.LocalDateTime;

public class MeterReading {
    private String meterId;
    private double reading;
    private LocalDateTime timestamp;

    // Constructors
    public MeterReading() {}

    public MeterReading(String meterId, double reading, LocalDateTime timestamp) {
        this.meterId = meterId;
        this.reading = reading;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getMeterId() {
        return meterId;
    }

    public void setMeterId(String meterId) {
        this.meterId = meterId;
    }

    public double getReading() {
        return reading;
    }

    public void setReading(double reading) {
        this.reading = reading;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
