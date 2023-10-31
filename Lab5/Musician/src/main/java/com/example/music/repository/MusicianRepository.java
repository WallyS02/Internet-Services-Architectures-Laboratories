package com.example.music.repository;

import com.example.music.entity.Instrument;
import com.example.music.entity.Musician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MusicianRepository extends JpaRepository<Musician, UUID> {
    List<Musician> findAllByInstrument(Instrument instrument);

    Optional<Musician> findByName(String name);
}
