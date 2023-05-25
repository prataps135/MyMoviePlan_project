import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Movie } from 'src/app/model/Movie';
import { Resource } from 'src/app/model/Resource';
import { MovieService } from 'src/app/services/Movie/movie.service';
import { NotificationService } from 'src/app/services/Notification/notification.service';

@Component({
  selector: 'app-add-movie',
  templateUrl: './add-movie.component.html',
  styleUrls: ['./add-movie.component.scss']
})
export class AddMovieComponent {
  // genres: any;
  // resources: Resource[] = [];
  // addMovieForm: FormGroup;
  // constructor(
  //   private formBuilder: FormBuilder,
  //   private movieService: MovieService,
  //   private router: Router,
  //   private resourceService: MovieResourceService,
  //   private notifyService: NotificationService
  // ) {}

  // ngOnInit() {
  //   this.addMovieForm = this.formBuilder.group({
  //     mname: ['', [Validators.required, Validators.maxLength(25)]],
  //     cast: ['', [Validators.required, Validators.minLength(10)]],
  //     director: [
  //       '',
  //       [
  //         Validators.required,
  //         Validators.pattern('[a-zA-Z][a-zA-Z ]+'),
  //         Validators.minLength(3),
  //         Validators.maxLength(20),
  //       ],
  //     ],
  //     mgenre: ['', Validators.required],
  //     mdesc: ['', [Validators.required, Validators.minLength(10)]],
  //     language: [
  //       '',
  //       [
  //         Validators.required,
  //         Validators.pattern('[a-zA-Z][a-zA-Z ]+'),
  //         Validators.minLength(3),
  //         Validators.maxLength(20),
  //       ],
  //     ],
  //     runTime: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
  //     ticketPrice: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
  //     movieCode: [
  //       '',
  //       [
  //         Validators.required,
  //         Validators.minLength(4),
  //         Validators.maxLength(25),
  //       ],
  //     ],
  //   });
  //   this.resourceService.getAllResources().subscribe((response: any) => {
  //     this.resources = response;
  //     const categories = this.resources.filter(
  //       (resources) => resources.resourceCode === 'genre'
  //     );
  //     const final = categories.map((categories) => categories.resourceDetail);
  //     this.genres = final;
  //   });
  // }

  // addProduct() {
  //   if (this.addMovieForm.invalid) {
  //     return this.notifyService.showError('All fields are Mandatory', 'Movie');
  //   }

  //   const mid = 0;
  //   const mname = this.addMovieForm.controls['mname'].value;
  //   const mgenre = this.addMovieForm.controls['mgenre'].value;
  //   const mdesc = this.addMovieForm.controls['mdesc'].value;
  //   const ticketPrice = this.addMovieForm.controls['ticketPrice'].value;
  //   const body: Movie = {
  //     id: mid,
  //     movieName: mname,
  //     genre: mgenre,
  //     movieDescription: mdesc,
  //     ticketValue: ticketPrice,
  //   };
  //   this.movieService.addMovie(body).subscribe(
  //     (data: any) => {
  //       this.notifyService.showSuccess(
  //         'Product Added Successfully',
  //         'Movie Plan'
  //       );
  //       this.router.navigate(['/home/movies']);
  //     },
  //     (err) => {
  //       this.notifyService.showSuccess(
  //         'Product already exist or something went wrong',
  //         'Try again'
  //       );
  //     }
  //   );
  // }

  // cancel() {
  //   this.notifyService.showWarn('Movie was not added', 'Cancelled');
  //   this.router.navigate(['/home']);
  // }

}
