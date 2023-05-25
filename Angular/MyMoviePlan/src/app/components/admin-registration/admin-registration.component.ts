import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Admin } from 'src/app/model/Admin';
import { AdminRegistrationService } from 'src/app/services/Admin registration/admin-registration.service';
import { NotificationService } from 'src/app/services/Notification/notification.service';

@Component({
  selector: 'app-admin-registration',
  templateUrl: './admin-registration.component.html',
  styleUrls: ['./admin-registration.component.scss']
})
export class AdminRegistrationComponent {
  adminRegForm: FormGroup;
  submitted = false;

  constructor(
    private formBuilder: FormBuilder,
    private notifyService: NotificationService,
    private router: Router,
    private adminRegService: AdminRegistrationService
  ) {}

  ngOnInit() {
    this.adminRegForm = this.formBuilder.group({
      userName: [
        '',
        [
          Validators.required,
          Validators.pattern('[a-zA-Z][a-zA-Z ]+'),
          Validators.minLength(4),
          Validators.maxLength(20),
        ],
      ],
      emailId: ['', Validators.required],
      password: [
        '',
        [
          Validators.required,
          Validators.minLength(6),
          Validators.maxLength(15),
        ],
      ],
      contactNo: [
        '',
        [Validators.required, Validators.pattern('^((\\+91-?)|0)?[0-9]{10}$')],
      ],
    });
  }

  get f() {
    return this.adminRegForm.controls;
  }

  onSubmit() {
    this.submitted = true;
    if (this.adminRegForm.invalid) {
      return this.notifyService.showError(
        'All fields are Mandatory',
        'Medicare'
      );
    }
  }

  adminReg() {
    const id = 0;
    const userName = this.adminRegForm.controls['userName'].value;
    const emailId = this.adminRegForm.controls['emailId'].value;
    const password = this.adminRegForm.controls['password'].value;
    const contactNo = this.adminRegForm.controls['contactNo'].value;
    const data: Admin = {
      id: id,
      adminName: userName,
      adminEmail: emailId,
      adminPassword: password,
      adminContact: contactNo,
    };
    this.adminRegService.addAdmin(data).subscribe(
      (data: any) => {
        this.notifyService.showSuccess('You are Registered', 'Successfully');
        this.router.navigate(['/home']);
      },
      (err) => {
        if (this.adminRegForm.valid) {
          this.notifyService.showError(
            'You are already registered',
            'try again'
          );
          this.adminRegForm.reset();
        }
      }
    );
  }

  cancel() {
    this.notifyService.showWarn('You are not registered', 'cancelled');
    this.router.navigate(['/home']);
  }

}
