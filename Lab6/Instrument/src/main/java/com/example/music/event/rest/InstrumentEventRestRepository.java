package com.example.music.event.rest;

import com.example.music.event.api.InstrumentEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class InstrumentEventRestRepository implements InstrumentEventRepository {
    private final RestTemplate restTemplate;

    @Autowired
    public InstrumentEventRestRepository(RestTemplate template) {
        this.restTemplate = template;
    }

    @Override
    public void create(UUID id) {
        restTemplate.put("/api/instruments/{id}", null, id);
    }

    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/instruments/{id}", id);
    }
}
