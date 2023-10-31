package com.example.music.function;

import com.example.music.dto.PutInstrumentRequest;
import com.example.music.entity.Instrument;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToInstrumentFunction implements BiFunction<UUID, PutInstrumentRequest, Instrument> {

    @Override
    public Instrument apply(UUID id, PutInstrumentRequest request) {
        return Instrument.builder()
                .id(id)
                .name(request.getName())
                .type(request.getType())
                .build();
    }
}
