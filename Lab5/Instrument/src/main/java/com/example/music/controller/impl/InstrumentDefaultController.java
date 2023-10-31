package com.example.music.controller.impl;

import com.example.music.controller.api.InstrumentController;
import com.example.music.dto.GetInstrumentResponse;
import com.example.music.dto.GetInstrumentsResponse;
import com.example.music.dto.PatchInstrumentRequest;
import com.example.music.dto.PutInstrumentRequest;
import com.example.music.function.InstrumentToResponseFunction;
import com.example.music.function.InstrumentsToResponseFunction;
import com.example.music.function.RequestToInstrumentFunction;
import com.example.music.function.UpdateInstrumentWithRequestFunction;
import com.example.music.service.InstrumentService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class InstrumentDefaultController implements InstrumentController {
    private final InstrumentService service;
    private final InstrumentToResponseFunction instrumentToResponse;
    private final InstrumentsToResponseFunction instrumentsToResponse;
    private final RequestToInstrumentFunction requestToInstrument;
    private final UpdateInstrumentWithRequestFunction updateInstrumentWithRequest;

    @Autowired
    public InstrumentDefaultController(InstrumentService service, InstrumentToResponseFunction instrumentToResponse, InstrumentsToResponseFunction instrumentsToResponse, RequestToInstrumentFunction requestToInstrument, UpdateInstrumentWithRequestFunction updateInstrumentWithRequest) {
        this.service = service;
        this.instrumentToResponse = instrumentToResponse;
        this.instrumentsToResponse = instrumentsToResponse;
        this.requestToInstrument = requestToInstrument;
        this.updateInstrumentWithRequest = updateInstrumentWithRequest;
    }

    @Override
    public GetInstrumentsResponse getInstruments() {
        return instrumentsToResponse.apply(service.findAll());
    }

    @Override
    public GetInstrumentResponse getInstrument(UUID id) {
        return service.find(id)
                .map(instrumentToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putInstrument(UUID id, PutInstrumentRequest request) {
        service.create(requestToInstrument.apply(id, request));
    }

    @Override
    public void deleteInstrument(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        instrument -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

    @Override
    public void patchInstrument(UUID id, PatchInstrumentRequest request) {
        service.find(id)
                .ifPresentOrElse(
                        instrument -> service.update(updateInstrumentWithRequest.apply(instrument, request)),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}
