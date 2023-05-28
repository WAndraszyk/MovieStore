package com.wandraszyk.movies.model;

import com.wandraszyk.movies.dto.MovieDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String title;

    private String genre;

    private String productionYear;

    private String plot;

    private Double price;

    private String imageUrl;

    public MovieDTO getDTO() {
        return new MovieDTO(id, title, genre, productionYear, plot, price, imageUrl);
    }
}
