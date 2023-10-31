package com.example.music.function;

import com.example.music.dto.GetMusiciansResponse;
import com.example.music.entity.Musician;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class MusiciansToResponseFunction implements Function<List<Musician>, GetMusiciansResponse> {

    @Override
    public GetMusiciansResponse apply(List<Musician> musicians) {
        return GetMusiciansResponse.builder()
                .musicians(musicians.stream()
                        .map(musician -> GetMusiciansResponse.Musician.builder()
                                .id(musician.getId())
                                .name(musician.getName())
                                .build())
                        .toList())
                .build();
    }
}
