package com.example.music.controller.impl;

import com.example.music.controller.api.InstrumentController;
import com.example.music.function.RequestToInstrumentFunction;
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
    private final RequestToInstrumentFunction requestToInstrument;

    @Autowired
    public InstrumentDefaultController(InstrumentService service, RequestToInstrumentFunction requestToInstrument1) {
        this.service = service;
        this.requestToInstrument = requestToInstrument1;
    }

    @Override
    public void putInstrument(UUID id) {
        service.create(requestToInstrument.apply(id));
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
}
