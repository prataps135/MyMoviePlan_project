import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Users } from 'src/app/model/User';

@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {

  constructor(private http: HttpClient) { }

  addUser(data: Users) {
    const url = "http://localhost/api/add/admin";
    let options = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-originPatterns': '*',
        'Access-Control-Allow-Headers': '*',
      }),
    };
    return this.http.post(url, data, options);
  }
}
