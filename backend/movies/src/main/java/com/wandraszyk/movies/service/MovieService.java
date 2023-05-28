package com.wandraszyk.movies.service;

import com.wandraszyk.movies.exception.MovieNotFoundException;
import com.wandraszyk.movies.model.Movie;
import com.wandraszyk.movies.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    public Movie updateMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie findMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    public List<String> getCategories() {
        return movieRepository.getCategories();
    }

    public List<Movie> getAllByGenre(String genre) {
        return movieRepository.searchByGenre(genre.toLowerCase());
    }
}
