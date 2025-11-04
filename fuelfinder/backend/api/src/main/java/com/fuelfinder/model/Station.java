package com.fuelfinder.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

import java.time.Instant;

@Document("stations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Station {
    @Id private String id;
    private String name;
    private String address;
    private double lat;
    private double lng;
    private double price;
    private Instant lastUpdated;
}