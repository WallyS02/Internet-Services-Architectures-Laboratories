package com.example.music.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "musicians")
public class Musician implements Serializable {
    @Id
    private UUID id;
    private String name;
    private String pseudonym;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "instrument")
    private Instrument instrument;
}
