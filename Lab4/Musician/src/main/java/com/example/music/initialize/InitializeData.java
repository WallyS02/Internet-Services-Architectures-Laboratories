package com.example.music.initialize;

import com.example.music.entity.Instrument;
import com.example.music.entity.Musician;
import com.example.music.service.InstrumentService;
import com.example.music.service.MusicianService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final MusicianService musicianService;
    private final InstrumentService instrumentService;

    @Autowired
    public InitializeData(MusicianService musicianService, InstrumentService instrumentService) {
        this.musicianService = musicianService;
        this.instrumentService = instrumentService;
    }

    @Override
    public void afterPropertiesSet() {
        Instrument instrument1 = Instrument.builder()
                .id(UUID.fromString("5ef603ba-33ce-483a-8ee7-bf04addceb41"))
                .build();
        Instrument instrument2 = Instrument.builder()
                .id(UUID.randomUUID())
                .build();
        Instrument instrument3 = Instrument.builder()
                .id(UUID.randomUUID())
                .build();
        instrumentService.create(instrument1);
        instrumentService.create(instrument2);
        instrumentService.create(instrument3);

        Musician musician1 = Musician.builder()
                .id(UUID.fromString("7b161086-17dc-453b-8e61-069fdb6cf065"))
                .name("Josh Homme")
                .pseudonym("Carlo Von Sexron")
                .instrument(instrument1)
                .build();
        Musician musician2 = Musician.builder()
                .id(UUID.randomUUID())
                .name("Tony Iommi")
                .pseudonym("Methuselah")
                .instrument(instrument1)
                .build();
        Musician musician3 = Musician.builder()
                .id(UUID.randomUUID())
                .name("Eric Clapton")
                .pseudonym("Slowhand")
                .instrument(instrument1)
                .build();
        Musician musician4 = Musician.builder()
                .id(UUID.randomUUID())
                .name("David Gilmour")
                .pseudonym("Pinky")
                .instrument(instrument1)
                .build();
        Musician musician5 = Musician.builder()
                .id(UUID.randomUUID())
                .name("Michael Shuman")
                .pseudonym("Mikey Shoes")
                .instrument(instrument2)
                .build();
        Musician musician6 = Musician.builder()
                .id(UUID.randomUUID())
                .name("Terence Butler")
                .pseudonym("Geezer")
                .instrument(instrument2)
                .build();
        Musician musician7 = Musician.builder()
                .id(UUID.randomUUID())
                .name("Michael Balzary")
                .pseudonym("Flea")
                .instrument(instrument2)
                .build();
        Musician musician8 = Musician.builder()
                .id(UUID.randomUUID())
                .name("Les Claypool")
                .pseudonym("Primus")
                .instrument(instrument2)
                .build();
        Musician musician9 = Musician.builder()
                .id(UUID.randomUUID())
                .name("Bill Ward")
                .pseudonym("Sabbath")
                .instrument(instrument3)
                .build();
        Musician musician10 = Musician.builder()
                .id(UUID.randomUUID())
                .name("Nick Mason")
                .pseudonym("Floyd")
                .instrument(instrument3)
                .build();
        Musician musician11 = Musician.builder()
                .id(UUID.randomUUID())
                .name("Sean Kinney")
                .pseudonym("Alice")
                .instrument(instrument3)
                .build();
        Musician musician12 = Musician.builder()
                .id(UUID.randomUUID())
                .name("Ben Thatcher")
                .pseudonym("Royal")
                .instrument(instrument3)
                .build();
        musicianService.create(musician1);
        musicianService.create(musician2);
        musicianService.create(musician3);
        musicianService.create(musician4);
        musicianService.create(musician5);
        musicianService.create(musician6);
        musicianService.create(musician7);
        musicianService.create(musician8);
        musicianService.create(musician9);
        musicianService.create(musician10);
        musicianService.create(musician11);
        musicianService.create(musician12);
    }
}
