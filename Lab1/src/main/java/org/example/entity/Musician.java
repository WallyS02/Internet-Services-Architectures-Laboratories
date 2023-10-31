package org.example.entity;

import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class Musician implements Serializable {
    private String name;
    private String pseudonym;
    private Instrument instrument;
}
