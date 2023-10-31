package com.example.music.controller.api;

import com.example.music.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface MusicianController {
    @GetMapping("api/musicians")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMusiciansResponse getMusicians();

    @GetMapping("/api/instruments/{instrumentId}/musicians")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMusiciansResponse getInstrumentMusicians(
            @PathVariable("instrumentId")
            UUID instrumentId
    );

    @GetMapping("/api/musicians/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMusicianResponse getMusician(
            @PathVariable("id")
            UUID id
    );

    @PutMapping("/api/musicians/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putMusician(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutMusicianRequest request
    );

    @DeleteMapping("/api/musicians/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteMusician(
            @PathVariable("id")
            UUID id
    );

    @PatchMapping("/api/musicians/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void patchMusician(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PatchMusicianRequest request
    );
}
