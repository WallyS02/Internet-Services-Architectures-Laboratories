package com.example.music.controller.api;

import com.example.music.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface InstrumentController {
    @GetMapping("api/instruments")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetInstrumentsResponse getInstruments();

    @GetMapping("/api/instruments/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetInstrumentResponse getInstrument(
            @PathVariable("id")
            UUID id
    );

    @PutMapping("/api/instruments/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putInstrument(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutInstrumentRequest request
    );

    @DeleteMapping("/api/instruments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteInstrument(
            @PathVariable("id")
            UUID id
    );

    @PatchMapping("/api/instruments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void patchInstrument(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PatchInstrumentRequest request
    );
}
