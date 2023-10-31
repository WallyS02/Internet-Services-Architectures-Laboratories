package org.example.dto;

import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
@EqualsAndHashCode
public class MusicianDTO implements Serializable {
    private String name;
    private String pseudonym;
    private String instrument;
}
