package com.example.music.service;

import com.example.music.entity.Musician;
import com.example.music.repository.InstrumentRepository;
import com.example.music.repository.MusicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MusicianService {
    private final MusicianRepository musicianRepository;
    private final InstrumentRepository instrumentRepository;

    @Autowired
    public MusicianService(MusicianRepository repository, InstrumentRepository professionRepository) {
        this.musicianRepository = repository;
        this.instrumentRepository = professionRepository;
    }

    public Optional<Musician> find(UUID id) {
        return musicianRepository.findById(id);
    }

    public List<Musician> findAll() {
        return musicianRepository.findAll();
    }

    public Optional<List<Musician>> findAllByInstrument(UUID instrumentId) {
        return instrumentRepository.findById(instrumentId)
                .map(musicianRepository::findAllByInstrument);
    }

    public Optional<Musician> findByName(String name) {
        return musicianRepository.findByName(name);
    }

    public void create(Musician musician) {
        musicianRepository.save(musician);
    }

    public void update(Musician musician) {
        musicianRepository.save(musician);
    }

    public void delete(UUID id) {
        musicianRepository.findById(id).ifPresent(musicianRepository::delete);
    }
}
