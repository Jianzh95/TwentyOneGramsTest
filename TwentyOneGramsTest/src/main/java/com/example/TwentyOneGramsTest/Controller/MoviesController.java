package com.example.TwentyOneGramsTest.Controller;

import com.example.TwentyOneGramsTest.Model.Movies;
import com.example.TwentyOneGramsTest.Service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @GetMapping("/allMovies")
    public List<Movies> getAllMovies() throws Exception {
        return moviesService.getAllMovies();
    }

    @GetMapping(value="/movies/{title}")
    public Movies getOneMovie(@PathVariable String title) {
        return moviesService.getOneMovie(title);
    }

    @GetMapping(value="/movies/{genre}/{language}")
    public List<Movies> getGenreAndLanguage(@PathVariable String genre, @PathVariable String language) {
        return moviesService.getMoviesGenreAndLanguage(genre, language);
    }

    @GetMapping(value = "/allTitleMovies/{title}")
    public List<Movies> getTitleByFilter(@PathVariable String title) {
        return moviesService.getTitleByFilter(title);
    }

    @GetMapping(value="/allPlotMovies/{plot}")
    public List<Movies> getPlotByFilter(@PathVariable String plot) {
        return moviesService.getPlotByFilter(plot);
    }

    @GetMapping(value="/allDirectorMovies/{director}")
    public List<Movies> getDirectorByFilter(@PathVariable String director) {
        return moviesService.getDirectorByFilter(director);
    }

    @GetMapping(value="/allActorMovies/{actor}")
    public List<Movies> getActorByFilter(@PathVariable String actor) {
        return moviesService.getActorByFilter(actor);
    }
}
