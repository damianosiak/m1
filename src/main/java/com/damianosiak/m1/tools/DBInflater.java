package com.damianosiak.m1.tools;

import com.damianosiak.m1.model.Artist;
import com.damianosiak.m1.model.Song;
import com.damianosiak.m1.repositories.ArtistRepository;
import com.damianosiak.m1.repositories.SongRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DBInflater implements ApplicationListener<ContextRefreshedEvent> {

    public DBInflater(SongRepository songRepository, ArtistRepository artistRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
    }

    private SongRepository songRepository;
    private ArtistRepository artistRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Artist johnny = new Artist("Johnny", "Cash", "cash");
        Song aBoyNamedSue = new Song("A Boy Named Sue", "country", "1983129873",
                "1969", "columbia");
        johnny.getSongs().add(aBoyNamedSue);
        aBoyNamedSue.getArtists().add(johnny);
        artistRepository.save(johnny);
        songRepository.save(aBoyNamedSue);


        Artist bob = new Artist("Bob", "Marley", "BoB");
        Song threeLittleBirds = new Song("Three little birds", "Raegge", "98172391123",
                "1977", "island");
        bob.getSongs().add(threeLittleBirds);
        threeLittleBirds.getArtists().add(bob);
        artistRepository.save(bob);
        songRepository.save(threeLittleBirds);



        Artist freddie = new Artist("Freddie", "Mercury", "Freddie");
        Song callingAllGirls = new Song("Calling All Girls", "Many", "09309823091",
                "1982", "emi");
        freddie.getSongs().add(callingAllGirls);
        callingAllGirls.getArtists().add(freddie);
        artistRepository.save(freddie);
        songRepository.save(callingAllGirls);

    }
}