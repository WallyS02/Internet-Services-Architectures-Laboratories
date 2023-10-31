package com.example.music.function;

import com.example.music.dto.GetInstrumentsResponse;
import com.example.music.entity.Instrument;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class InstrumentsToResponseFunction implements Function<List<Instrument>, GetInstrumentsResponse> {

    @Override
    public GetInstrumentsResponse apply(List<Instrument> instruments) {
        return GetInstrumentsResponse.builder()
                .instruments(instruments.stream()
                        .map(instrument -> GetInstrumentsResponse.Instrument.builder()
                                .id(instrument.getId())
                                .name(instrument.getName())
                                .build())
                        .toList())
                .build();
    }
}
