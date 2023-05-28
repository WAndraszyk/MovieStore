package com.wandraszyk.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MovieDTO {

    private Long id;

    private String title;

    private String genre;

    private String productionYear;

    private String plot;

    private Double price;

    private String imageUrl;
}
