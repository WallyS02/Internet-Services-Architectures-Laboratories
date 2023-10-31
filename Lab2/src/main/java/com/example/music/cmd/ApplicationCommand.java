package com.example.music.cmd;

import com.example.music.entity.Instrument;
import com.example.music.entity.Musician;
import com.example.music.service.InstrumentService;
import com.example.music.service.MusicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ApplicationCommand implements CommandLineRunner {

    private final MusicianService musicianService;
    private final InstrumentService instrumentService;

    @Autowired
    public ApplicationCommand(MusicianService musicianService, InstrumentService instrumentService) {
        this.musicianService = musicianService;
        this.instrumentService = instrumentService;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Command List");
        System.out.println("get_commands - check all commands");
        System.out.println("get_musicians - check all musicians");
        System.out.println("get_instruments - check all instruments");
        System.out.println("add_musician - add musician");
        System.out.println("delete_musician - delete musician");
        System.out.println("quit - exit application");
        String command;
        main_loop:
        while (true) {
            command = scanner.next();
            switch (command) {
                case "get_commands" -> {
                    System.out.println("Command List");
                    System.out.println("get_commands - check all commands");
                    System.out.println("get_musicians - check all musicians");
                    System.out.println("get_instruments - check all instruments");
                    System.out.println("add_musician - add musician");
                    System.out.println("delete_musician - delete musician");
                    System.out.println("quit - exit application");
                }
                case "get_musicians" -> {
                    System.out.println(musicianService.findAll());
                }
                case "get_instruments" -> {
                    System.out.println(instrumentService.findAll());
                }
                case "add_musician" -> {
                    System.out.println("Input name");
                    String name = scanner.next();
                    System.out.println("Input pseudonym");
                    String pseudonym = scanner.next();
                    System.out.println("Choose instrument");
                    List<Instrument> instruments = instrumentService.findAll();
                    instruments.forEach(instrument -> System.out.println(instrument.getName()));
                    System.out.println("Input chosen instrument name");
                    String instrumentName = scanner.next();
                    Optional<Instrument> instrumentOpt = instrumentService.findByName(instrumentName);
                    Instrument instrument = null;
                    if (instrumentOpt.isPresent()) {
                        instrument = instrumentOpt.get();
                    }
                    Musician musician = Musician.builder()
                            .id(UUID.randomUUID())
                            .name(name)
                            .pseudonym(pseudonym)
                            .instrument(instrument)
                            .build();
                    try {
                        musicianService.create(musician);
                        System.out.println("Musician added");
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Bad Request");
                    }
                }
                case "delete_musician" -> {
                    try {
                        System.out.println("Input name");
                        String name = scanner.next();
                        Optional<Musician> musicianOpt = musicianService.findByName(name);
                        Musician musician = null;
                        if (musicianOpt.isPresent()) {
                            musician = musicianOpt.get();
                        }
                        assert musician != null;
                        musicianService.delete(musician.getId());
                        System.out.println("Musician deleted");
                    } catch (NoSuchElementException ex) {
                        System.out.println("Not Found");
                    }
                }
                case "quit" -> {
                    break main_loop;
                }
                default -> System.out.println("Invalid command");
            }
        }
    }
}
