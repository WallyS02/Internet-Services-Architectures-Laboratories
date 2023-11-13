package com.example.music.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutMusicianRequest {
    private String name;
    private String pseudonym;
    private UUID instrument;
}
