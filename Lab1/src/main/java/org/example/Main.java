package org.example;

import org.example.dto.MusicianDTO;
import org.example.entity.Instrument;
import org.example.entity.Musician;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Task 2
        Instrument instrument1 = Instrument.builder()
                .name("guitar")
                .type("strings")
                .musicians(new ArrayList<>())
                .build();

        Instrument instrument2 = Instrument.builder()
                .name("bass guitar")
                .type("strings")
                .musicians(new ArrayList<>())
                .build();

        Musician musician1 = Musician.builder()
                .name("Josh Homme")
                .pseudonym("Carlo Von Sexron")
                .instrument(instrument1)
                .build();

        Musician musician2 = Musician.builder()
                .name("Michael Shuman")
                .pseudonym("Mikey Shoes")
                .instrument(instrument2)
                .build();

        Musician musician3 = Musician.builder()
                .name("Tony Iommi")
                .pseudonym("Methuselah")
                .instrument(instrument1)
                .build();

        Musician musician4 = Musician.builder()
                .name("Terence Butler")
                .pseudonym("Geezer")
                .instrument(instrument2)
                .build();

        instrument1.getMusicians().add(musician1);
        instrument1.getMusicians().add(musician3);

        instrument2.getMusicians().add(musician2);
        instrument2.getMusicians().add(musician4);

        List<Instrument> instruments = new ArrayList<>();
        instruments.add(instrument1);
        instruments.add(instrument2);

        instruments.forEach(instrument -> {
            System.out.println("Instrument: " + instrument);
            instrument.getMusicians().forEach(musician -> System.out.println("Musician: " + musician));
        });

        // Task 3
        Set<Musician> allMusicians = instruments.stream()
                .flatMap(instrument -> instrument.getMusicians().stream())
                .collect(Collectors.toSet());

        System.out.println("\nAll Musicians:");
        allMusicians.forEach(musician -> System.out.println("Musician: " + musician));

        // Task 4
        List<Musician> filteredAndSortedMusicians = allMusicians.stream()
                .filter(musician -> musician.getPseudonym().equals("Geezer"))
                .sorted(Comparator.comparing(Musician::getName))
                .toList();

        System.out.println("\nFiltered and Sorted Musicians:");
        filteredAndSortedMusicians.forEach(musician -> System.out.println("Musician: " + musician));

        // Task 5
        List<MusicianDTO> musicianDTOList = allMusicians.stream()
                .map(musician -> MusicianDTO.builder()
                        .name(musician.getName())
                        .pseudonym(musician.getPseudonym())
                        .instrument(musician.getInstrument().getName())
                        .build())
                .sorted(Comparator.comparing(MusicianDTO::getName))
                .toList();

        System.out.println("\nMusician DTOs:");
        musicianDTOList.forEach(musicianDTO -> System.out.println("Musician DTO: " + musicianDTO));

        // Task 6
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("instruments.bin"));
            oos.writeObject(instruments);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("instruments.bin"));
            List<Instrument> deserializedInstruments = (List<Instrument>) ois.readObject();
            ois.close();

            System.out.println("\nDeserialized:");
            deserializedInstruments.forEach(deserializedInstrument -> {
                System.out.println("Instrument: " + deserializedInstrument);
                deserializedInstrument.getMusicians().forEach(musician -> System.out.println("Musician: " + musician));
            });
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Task 7
        int[] customPoolSizes = {2, 4, 8};
        for (int poolSize : customPoolSizes) {
            ForkJoinPool customThreadPool = new ForkJoinPool(poolSize);
            try {
                System.out.println("\nForkJoinPool Size: " + poolSize);
                customThreadPool.submit(() ->
                        instruments.parallelStream().forEach(instrument -> instrument.getMusicians().forEach(musician -> {
                            System.out.println("Instrument: " + instrument + ", Musician: " + musician);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }))
                ).join();
            } finally {
                customThreadPool.shutdown();
            }
        }
    }
}
