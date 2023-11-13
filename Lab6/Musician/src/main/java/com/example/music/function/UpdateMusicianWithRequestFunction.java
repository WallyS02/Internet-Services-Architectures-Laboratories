package com.example.music.function;

import com.example.music.dto.PatchMusicianRequest;
import com.example.music.entity.Musician;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class UpdateMusicianWithRequestFunction implements BiFunction<Musician, PatchMusicianRequest, Musician> {

    @Override
    public Musician apply(Musician musician, PatchMusicianRequest request) {
        return Musician.builder()
                .id(musician.getId())
                .name(request.getName())
                .pseudonym(request.getPseudonym())
                .instrument(musician.getInstrument())
                .build();
    }
}
