package com.damianosiak.m1.repositories;

import com.damianosiak.m1.model.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
}
