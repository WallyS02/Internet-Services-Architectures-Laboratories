package com.example.music.function;

import com.example.music.entity.Instrument;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;
import java.util.function.Function;

@Component
public class RequestToInstrumentFunction implements Function<UUID, Instrument> {

    @Override
    public Instrument apply(UUID id) {
        return Instrument.builder()
                .id(id)
                .musicians(new ArrayList<>())
                .build();
    }
}
