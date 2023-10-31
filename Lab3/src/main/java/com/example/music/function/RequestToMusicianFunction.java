package com.example.music.function;

import com.example.music.dto.PutMusicianRequest;
import com.example.music.entity.Instrument;
import com.example.music.entity.Musician;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToMusicianFunction implements BiFunction<UUID, PutMusicianRequest, Musician> {

    @Override
    public Musician apply(UUID id, PutMusicianRequest request) {
        return Musician.builder()
                .id(id)
                .name(request.getName())
                .pseudonym(request.getPseudonym())
                .instrument(Instrument.builder()
                        .id(request.getInstrument())
                        .build())
                .build();
    }
}
