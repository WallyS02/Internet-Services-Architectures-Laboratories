package com.example.music.controller.impl;

import com.example.music.controller.api.MusicianController;
import com.example.music.dto.GetMusicianResponse;
import com.example.music.dto.GetMusiciansResponse;
import com.example.music.dto.PatchMusicianRequest;
import com.example.music.dto.PutMusicianRequest;
import com.example.music.function.MusicianToResponseFunction;
import com.example.music.function.MusiciansToResponseFunction;
import com.example.music.function.RequestToMusicianFunction;
import com.example.music.function.UpdateMusicianWithRequestFunction;
import com.example.music.service.MusicianService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class MusicianDefaultController implements MusicianController {
    private final MusicianService service;
    private final MusicianToResponseFunction musicianToResponse;
    private final MusiciansToResponseFunction musiciansToResponse;
    private final RequestToMusicianFunction requestToMusician;
    private final UpdateMusicianWithRequestFunction updateMusicianWithRequest;

    @Autowired
    public MusicianDefaultController(MusicianService service, MusicianToResponseFunction musicianToResponse, MusiciansToResponseFunction musiciansToResponse, RequestToMusicianFunction requestToMusician, UpdateMusicianWithRequestFunction updateMusicianWithRequest) {
        this.service = service;
        this.musicianToResponse = musicianToResponse;
        this.musiciansToResponse = musiciansToResponse;
        this.requestToMusician = requestToMusician;
        this.updateMusicianWithRequest = updateMusicianWithRequest;
    }

    @Override
    public GetMusiciansResponse getMusicians() {
        return musiciansToResponse.apply(service.findAll());
    }

    @Override
    public GetMusiciansResponse getInstrumentMusicians(UUID instrumentId) {
        return service.findAllByInstrument(instrumentId)
                .map(musiciansToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetMusicianResponse getMusician(UUID id) {
        return service.find(id)
                .map(musicianToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putMusician(UUID id, PutMusicianRequest request) {
        service.create(requestToMusician.apply(id, request));
    }

    @Override
    public void deleteMusician(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        musician -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

    @Override
    public void patchMusician(UUID id, PatchMusicianRequest request) {
        service.find(id)
                .ifPresentOrElse(
                        musician -> service.update(updateMusicianWithRequest.apply(musician, request)),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}
