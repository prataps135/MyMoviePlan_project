import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IAdmin } from 'src/app/model/Admin';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) { }

  getByEmail(email: string) {
    const url = 'http://localhost:1800/api/admin';
    let options = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-originPatterns': '*',
        'Access-Control-Allow-Headers': '*',
      }),
    };
    return this.http.get(url + '/' + email, options);
  }

  // public getByEmailAndPassword(admin: IAdmin) {
  //   const url = 'http://localhost:1800/api/admin/login';
  //   let options = {
  //     headers: new HttpHeaders({
  //       'Content-Type': 'application/json',
  //       'Access-Control-Allow-originPatterns': '*',
  //       'Access-Control-Allow-Headers': '*',
  //     }),
  //   };
  //   return this.http.post(url, admin, options);
  // }

}
