import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {Movie} from './movie';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class MovieService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getAllMovies(): Observable<Movie[]> {
    return this.http.get<Movie[]>(`${this.apiServerUrl}/movie`);
  }

  public getMovie(movieId: number): Observable<Movie> {
    return this.http.get<Movie>(`${this.apiServerUrl}/movie/${movieId}`);
  }

  public addMovie(movie: Movie): Observable<Movie> {
    return this.http.post<Movie>(`${this.apiServerUrl}/movie`, movie);
  }

  public updateMovie(movie: Movie): Observable<Movie> {
    return this.http.put<Movie>(`${this.apiServerUrl}/movie`, movie);
  }

  public deleteMovie(movieId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/movie/${movieId}`);
  }

  public getCategories(): Observable<string[]> {
    return this.http.get<string[]>(`${this.apiServerUrl}/movie/categories`);
  }

  public getMoviesByCategory(category: string): Observable<Movie[]> {
    return this.http.get<Movie[]>(`${this.apiServerUrl}/movie/genre/${category}`);
  }
}
