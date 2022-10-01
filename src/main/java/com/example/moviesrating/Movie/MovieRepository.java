package com.example.moviesrating.Movie;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(value = "SELECT * FROM movie WHERE id = ?1", nativeQuery = true)
    Movie findMovieById(Long id);

    @Query(value = "SELECT name FROM movie", nativeQuery = true)
    List<String> findAllMovieNames();
}
