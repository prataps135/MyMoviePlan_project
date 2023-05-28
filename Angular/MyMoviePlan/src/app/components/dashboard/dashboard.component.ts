import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/Authentication/authentication.service';
import { NotificationService } from 'src/app/services/Notification/notification.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit{

  roleAdmin:any={};

  constructor(
    private authService :AuthenticationService,
    private router: Router,
    private notifyService: NotificationService
  ) {}

  ngOnInit() {
    this.authService.getType().subscribe((val: any) => {
      this.roleAdmin = val;
    });
  }

  onSignOut() {
    this.notifyService.showInfo('You are logged out', 'Session expired');
    this.router.navigate(['/']);
  }
}
