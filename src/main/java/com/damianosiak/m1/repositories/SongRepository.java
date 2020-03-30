package com.damianosiak.m1.repositories;

import com.damianosiak.m1.model.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {

}
