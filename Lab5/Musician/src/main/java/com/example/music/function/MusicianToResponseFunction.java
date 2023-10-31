package com.example.music.function;

import com.example.music.dto.GetMusicianResponse;
import com.example.music.entity.Musician;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MusicianToResponseFunction implements Function<Musician, GetMusicianResponse> {

    @Override
    public GetMusicianResponse apply(Musician musician) {
        return GetMusicianResponse.builder()
                .id(musician.getId())
                .name(musician.getName())
                .pseudonym(musician.getPseudonym())
                .instrument(GetMusicianResponse.Instrument.builder()
                        .id(musician.getInstrument().getId())
                        .build())
                .build();
    }
}
