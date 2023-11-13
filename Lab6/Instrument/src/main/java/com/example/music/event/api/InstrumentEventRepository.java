package com.example.music.event.api;

import java.util.UUID;

public interface InstrumentEventRepository {
    void create(UUID id);
    void delete(UUID id);
}
