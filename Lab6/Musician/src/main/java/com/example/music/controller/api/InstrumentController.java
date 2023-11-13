package com.example.music.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface InstrumentController {
    @PutMapping("/api/instruments/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putInstrument(
            @PathVariable("id")
            UUID id
    );

    @DeleteMapping("/api/instruments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteInstrument(
            @PathVariable("id")
            UUID id
    );
}
