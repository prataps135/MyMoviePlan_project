import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Admin } from 'src/app/model/Admin';

@Injectable({
  providedIn: 'root'
})
export class AdminRegistrationService {

  constructor(private http: HttpClient) { }

  addAdmin(data: Admin) {
    const url = "http://localhost:1800/api/add/admin";
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
