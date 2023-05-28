package com.wandraszyk.movies;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);

		log.info("""
    
				---------------------------------------------------------------------
				\tMovies Backend is running!
				---------------------------------------------------------------------
				
				""");
	}

}
