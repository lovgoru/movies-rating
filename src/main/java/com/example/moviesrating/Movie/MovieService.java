package com.example.moviesrating.Movie;


import org.decimal4j.util.DoubleRounder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void saveMovie(Movie movie) {
        movie.setRating(0.00);
        movieRepository.save(movie);
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll(Sort.by(Sort.Direction.DESC, "rating"));
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findMovieById(id);
    }

    @Transactional //potrebno je da bi se promjene na lokalnoj kopiji m'movie' ocitovale promjene u bazi podataka
    public void saveRate(Integer userRate, Long id) {
        Movie movie = movieRepository.findMovieById(id);
        movie.setVoteNum(movie.getVoteNum()+1);
        movie.setVoteSum(movie.getVoteSum()+userRate);
        movie.setRating(DoubleRounder.round((double)movie.getVoteSum()/movie.getVoteNum(), 2));
    }

    @Transactional //isti razlog kao i prije
    public void changeMovie(Movie changedMovie) {
        Movie movie = movieRepository.findMovieById(changedMovie.getId());

        if(changedMovie.getName() != ""){
            System.out.println(changedMovie.getName());
            movie.setName(changedMovie.getName());
        }

        if(changedMovie.getYear() != null){
            movie.setYear(changedMovie.getYear());
        }

        if(changedMovie.getLengthHours() != null){
            movie.setLengthHours(changedMovie.getLengthHours());
        }

        if(changedMovie.getLengthMinutes() != null){
            movie.setLengthMinutes(changedMovie.getLengthMinutes());
        }
    }

    public List<String> getAllMovieNames() {
        return movieRepository.findAllMovieNames();
    }
}
