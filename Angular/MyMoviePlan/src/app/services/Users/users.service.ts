import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable} from 'rxjs';
import { Users } from 'src/app/model/User';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  // private _rootUrl: string = "http://localhost:1800/api";

  constructor(private http: HttpClient) { }

  getByEmail(email: string) {
    const url = 'http://localhost:1800/api/user';
    let options = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-originPatterns': '*',
        'Access-Control-Allow-Headers': '*',
      }),
    };
    return this.http.get(`${url}/${email}`, options);
  }
}

