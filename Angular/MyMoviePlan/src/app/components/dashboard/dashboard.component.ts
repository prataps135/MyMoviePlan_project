import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NotificationService } from 'src/app/services/Notification/notification.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit{
  constructor(
    private router: Router,
    private notifyService: NotificationService
  ) {}

  ngOnInit() {}

  onSignOut() {
    this.notifyService.showInfo('You are logged out', 'Session expired');
    this.router.navigate(['/']);
  }
}
