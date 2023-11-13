package com.example.music.function;

import com.example.music.dto.PatchInstrumentRequest;
import com.example.music.entity.Instrument;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class UpdateInstrumentWithRequestFunction implements BiFunction<Instrument, PatchInstrumentRequest, Instrument> {

    @Override
    public Instrument apply(Instrument instrument, PatchInstrumentRequest request) {
        return Instrument.builder()
                .id(instrument.getId())
                .name(request.getName())
                .type(request.getType())
                .build();
    }
}
