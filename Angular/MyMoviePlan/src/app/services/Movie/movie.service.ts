import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Movie } from 'src/app/model/Movie';

@Injectable({
  providedIn: 'root'
})
export class MovieService {
  constructor(private http: HttpClient) { }

  public addMovie(data: Movie) {
    const url = 'http://localhost:1800/api/add/movie';
    let options = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-originPatterns': '*',
        'Access-Control-Allow-Headers': '*',
      }),
    };
    return this.http.post(url, data, options);
  }

  public getMovieById(mid: number) {
    const url = 'http://localhost:1800/api/movie/id';
    let options = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-originPatterns': '*',
        'Access-Control-Allow-Headers': '*',
      }),
    };
    return this.http.get(`${url}/${mid}`, options);
  }

  public updateMovie(mid: number, data: Movie) {
    const url = 'http://localhost:1800/api/movie/update';
    let options = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-originPatterns': '*',
        'Access-Control-Allow-Headers': '*',
      }),
    };
    return this.http.put(`${url}/${mid}`, data, options);
  }

  public deleteMovieById(mid: number) {
    const url = 'http://localhost:1800/api/movie/delete';
    let options = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-originPatterns': '*',
        'Access-Control-Allow-Headers': '*',
      }),
    };
    return this.http.delete(`${url}/${mid}`, options);
  }

  public getAllMovies() {
    const url = 'http://localhost:1800/api/movie/all';
    let options = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-originPatterns': '*',
        'Access-Control-Allow-Headers': '*',
      }),
    };
    return this.http.get(url, options);
  }

}
