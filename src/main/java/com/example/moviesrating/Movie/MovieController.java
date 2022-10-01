package com.example.moviesrating.Movie;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public String showHomeScreen(){
        return "index";
    }

    @GetMapping("/add-movie")
    public String showAddingPage(Model model){
        List<String> allMovieNames = movieService.getAllMovieNames();
        model.addAttribute("movieNames", allMovieNames);
        return "addMovie";
    }

    @PostMapping("/add-process")
    public String addMovie(Movie movie){
        movieService.saveMovie(movie);
        return "redirect:/list-of-movies";
    }

    @GetMapping("/list-of-movies")
    public String getMovies(Model model){
        List<Movie> movies = movieService.getMovies();
        model.addAttribute("movies", movies);
        return "listOfMovies";
    }

    @GetMapping("/list-of-movies/rate/{id}")
    public String showRatingPage(Model model, @PathVariable Long id){
        Movie movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);
        return "rateMovie";
    }

    @PostMapping("rate-process/{id}")
    public String saveRate(@RequestParam("rateRadioBtn") String rateRadioBtn, @PathVariable Long id){
        movieService.saveRate(Integer.parseInt(rateRadioBtn), id);
        return "redirect:/list-of-movies";
    }

    @GetMapping("/list-of-movies/change/{id}")
    public String showChangingPage(Model model, @PathVariable Long id){
        Movie movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);
        return "changeMovie";
    }

    @PostMapping("change-process/{id}")
    public String changeMovie(Movie movie){
        movieService.changeMovie(movie);
        return "redirect:/list-of-movies";
    }
}
