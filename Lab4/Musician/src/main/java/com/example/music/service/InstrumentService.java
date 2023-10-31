package com.example.music.service;

import com.example.music.entity.Instrument;
import com.example.music.repository.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class InstrumentService {
    private final InstrumentRepository instrumentRepository;

    @Autowired
    public InstrumentService(InstrumentRepository instrumentRepository) {
        this.instrumentRepository = instrumentRepository;
    }

    public Optional<Instrument> find(UUID id) {
        return instrumentRepository.findById(id);
    }

    public void create(Instrument instrument) {
        instrumentRepository.save(instrument);
    }

    public void update(Instrument instrument) {
        instrumentRepository.save(instrument);
    }

    public void delete(UUID id) {
        instrumentRepository.findById(id).ifPresent(instrumentRepository::delete);
    }
}
