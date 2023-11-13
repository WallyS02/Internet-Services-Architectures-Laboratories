package com.example.music.function;

import com.example.music.dto.GetInstrumentResponse;
import com.example.music.entity.Instrument;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class InstrumentToResponseFunction implements Function<Instrument, GetInstrumentResponse> {

    @Override
    public GetInstrumentResponse apply(Instrument instrument) {
        return GetInstrumentResponse.builder()
                .id(instrument.getId())
                .name(instrument.getName())
                .type(instrument.getType())
                .build();
    }
}
