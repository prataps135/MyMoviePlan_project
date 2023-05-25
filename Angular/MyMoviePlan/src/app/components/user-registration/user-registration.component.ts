import { Component,OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Users } from 'src/app/model/User';
import { NotificationService } from 'src/app/services/Notification/notification.service';
import { UserRegistrationService } from 'src/app/services/User registration/user-registration.service';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.scss']
})
export class UserRegistrationComponent implements OnInit{
  userRegisterForm: FormGroup;
  submitted = false;

  constructor(
    private formBuilder: FormBuilder,
    private notifyService: NotificationService,
    private userRegistrationService: UserRegistrationService,
    private router: Router
  ) {}

  ngOnInit() {
    this.userRegisterForm = this.formBuilder.group({
      name: [
        '',
        [
          Validators.required,
          Validators.pattern('[a-zA-Z][a-zA-Z ]+'),
          Validators.minLength(4),
          Validators.maxLength(20),
        ],
      ],
      email: ['', Validators.required],
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
    return this.userRegisterForm.controls;
  }

  onSubmit() {
    this.submitted = true;
    if (this.userRegisterForm.invalid) {
      return this.notifyService.showError(
        'All fields are Mandatory',
        'Movie Plan'
      );
    }
  }

  register() {
    const id = 0;
    const name = this.userRegisterForm.controls['name'].value;
    const email = this.userRegisterForm.controls['email'].value;
    const password = this.userRegisterForm.controls['password'].value;
    const contactNo = this.userRegisterForm.controls['contactNo'].value;
    const body: Users = {
      id: id,
      userName: name,
      userEmail: email,
      userPassword: password,
      userContact: contactNo,
    };
    this.userRegistrationService.addUser(body).subscribe(
      (data: any) => {
        this.notifyService.showSuccess('You are Registered', 'Successfully');
        this.router.navigate(['/']);
      },
      (err) => {
        if (this.userRegisterForm.valid) {
          this.notifyService.showError(
            'You are already registered',
            'try again'
          );
        }
      }
    );
  }
  cancel() {
    this.notifyService.showWarn('You are not registered', 'Cancelled');
    this.router.navigate(['/']);
  }
}
