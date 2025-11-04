package com.fuelfinder.api.repo;

import com.fuelfinder.api.model.Station;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface StationRepo extends MongoRepository<Station, String> {}