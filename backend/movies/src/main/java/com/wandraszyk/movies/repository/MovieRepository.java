package com.wandraszyk.movies.repository;

import com.wandraszyk.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT DISTINCT m.genre FROM Movie m")
    List<String> getCategories();

    @Query("SELECT m FROM Movie m WHERE lower(m.genre) = :genre")
    List<Movie> searchByGenre(@Param("genre") String genre);
}
