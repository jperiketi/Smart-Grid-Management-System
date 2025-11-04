package com.fuelfinder.api.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuelfinder.api.model.Station;
import com.fuelfinder.api.repo.StationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class PriceConsumer {
    private final StationRepo repo;
    private final ObjectMapper om = new ObjectMapper();

    @KafkaListener(topics = "gas_prices", groupId = "fuelfinder")
    public void onMessage(String payload) throws Exception {
        Map<String, Object> msg = om.readValue(payload, Map.class);
        String id = (String) msg.get("stationId");
        double price = Double.parseDouble(msg.get("price").toString());
        repo.findById(id).ifPresent(s -> {
            s.setPrice(price);
            s.setLastUpdated(Instant.now());
            repo.save(s);
        });
    }
}