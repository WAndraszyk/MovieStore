import { Component, OnInit, ViewChild } from '@angular/core';
import { Movie } from './movie';
import { MovieService } from './movie.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'moviestoreapp';
  public movies: Movie[];
  public cartMovies: Movie[] = [];
  public totalPrice: string = "0.00";
  public totalPriceNum: number = 0;
  public chosenMovie: Movie;
  public categories: string[];

  constructor(private movieService: MovieService) { }

  @ViewChild('content') content: any;
  ngOnInit(): void {
    this.getAllMovies();
    this.getCategories();
  }

  public getAllMovies(): void {
    this.movieService.getAllMovies().subscribe(
      (response: Movie[]) => {
        this.movies = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

  public getCategories(): void {
    this.movieService.getCategories().subscribe(
      (response: string[]) => {
        this.categories = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

  public searchMovies(key: string): void {
    const results: Movie[] = [];
    for (const movie of this.movies) {
      if (movie.title.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(movie);
      }
    }
    this.movies = results;
    if (!key) {
      this.getAllMovies();
    }
  }

  public searchByCategory(key: string): void {
    this.movieService.getMoviesByCategory(key).subscribe(
      (response: Movie[]) => {
        this.movies = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
    if (!key || key === "all") {
      this.getAllMovies();
    }
  }

  public addToCart(movie: Movie): void {
    if (!this.cartMovies.includes(movie)) {
      this.cartMovies.push(movie);
      this.totalPriceNum += movie.price;
      this.totalPrice = this.totalPriceNum.toFixed(2)
    }
  }

  public removeFromCart(movie: Movie): void {
    const index = this.cartMovies.indexOf(movie, 0);
    if (index > -1) {
      this.cartMovies.splice(index, 1);
      this.totalPriceNum -= movie.price;
      if(this.totalPriceNum < 0){
        this.totalPriceNum = 0;
      }
      this.totalPrice = this.totalPriceNum.toFixed(2);
    }
  }

  public getInfo(movie: Movie): void {
    this.chosenMovie = movie;
  }
}
