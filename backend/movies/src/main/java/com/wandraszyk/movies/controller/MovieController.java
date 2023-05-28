package com.wandraszyk.movies.controller;

import com.wandraszyk.movies.dto.MovieDTO;
import com.wandraszyk.movies.model.Movie;
import com.wandraszyk.movies.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<Movie> movies = movieService.findAllMovies();
        List<MovieDTO> moviesDTO = movies.stream()
                .map(Movie::getDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(moviesDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovie(@PathVariable("id") Long id) {
        MovieDTO movie = movieService.findMovieById(id).getDTO();
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MovieDTO> getMovie(@RequestBody Movie movieBody) {
        MovieDTO movie = movieService.addMovie(movieBody).getDTO();
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<MovieDTO> updateMovie(@RequestBody Movie movieBody) {
        MovieDTO movie = movieService.updateMovie(movieBody).getDTO();
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable("id") Long id) {
        movieService.deleteMovie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<String>> getCategories() {
        List<String> categories = movieService.getCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<MovieDTO>> getAllByGenre(@PathVariable("genre") String genre) {
        List<Movie> movies = movieService.getAllByGenre(genre);
        List<MovieDTO> moviesDTO = movies.stream()
                .map(Movie::getDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(moviesDTO, HttpStatus.OK);
    }
}
