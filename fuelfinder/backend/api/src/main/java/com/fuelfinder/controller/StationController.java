package com.fuelfinder.api.controller;

import com.fuelfinder.api.model.Station;
import com.fuelfinder.api.repo.StationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stations")
@RequiredArgsConstructor
@CrossOrigin
public class StationController {
    private final StationRepo repo;

    @GetMapping
    public List<Station> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Station save(@RequestBody Station s) {
        return repo.save(s);
    }
}