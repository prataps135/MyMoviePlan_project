import { Component, Input } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {
  user: User;
  url: string = 'pratap@gmail.com';
  email: string = 'pratap@gmail.com';
  options = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-originPatterns': '*',
      'Access-Control-Allow-Headers': '*',
    }),
  };

  constructor(private http: HttpClient) { }
  ngOnInit() {
    // this.service.getUserByEmail(this.url).subscribe((data:any) => this.user = data);
    // this.user = this.service.getUserByEmail(this.url);
    const url = "http://localhost:1800/api/admin";
    return this.http.get(`${url}/${this.email}`,this.options).subscribe(
      (data:any) => { this.user = data },
      (err) => { console.log('this is err', err),
                  this.user = err.error }
    );

    console.log(this.user.adminContact);
  }


    // getUserByEmail(){
  //   const url="http://localhost:1800/admin";
  //   return this.http.get<User>(`${url}/${this.email}`).subscribe(
  //     (data)=>{this.user=data},
  //     (err)=>{console.log('this is err',err)}
  //   );
  // }
}
