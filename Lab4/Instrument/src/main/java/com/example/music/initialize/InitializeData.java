package com.example.music.initialize;

import com.example.music.entity.Instrument;
import com.example.music.service.InstrumentService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final InstrumentService instrumentService;

    @Autowired
    public InitializeData(InstrumentService instrumentService) {
        this.instrumentService = instrumentService;
    }

    @Override
    public void afterPropertiesSet() {
        Instrument instrument1 = Instrument.builder()
                .id(UUID.fromString("5ef603ba-33ce-483a-8ee7-bf04addceb41"))
                .name("guitar")
                .type("strings")
                .build();
        Instrument instrument2 = Instrument.builder()
                .id(UUID.randomUUID())
                .name("bass guitar")
                .type("strings")
                .build();
        Instrument instrument3 = Instrument.builder()
                .id(UUID.randomUUID())
                .name("drums")
                .type("percussion")
                .build();
        instrumentService.create(instrument1);
        instrumentService.create(instrument2);
        instrumentService.create(instrument3);
    }
}
