import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Movie } from 'src/app/model/Movie';
import { Resource } from 'src/app/model/Resource';
import { MovieService } from 'src/app/services/Movie/movie.service';
import { NotificationService } from 'src/app/services/Notification/notification.service';
import { MovieResourceService } from 'src/app/services/movie-resource/movie-resource.service';

@Component({
  selector: 'app-add-movie',
  templateUrl: './add-movie.component.html',
  styleUrls: ['./add-movie.component.scss']
})
export class AddMovieComponent {
  genres: any;
  resources: Resource[] = [];
  addMovieForm: FormGroup;
  constructor(
    private formBuilder: FormBuilder,
    private movieService: MovieService,
    private router: Router,
    private resourceService: MovieResourceService,
    private notifyService: NotificationService
  ) {}

  ngOnInit() {
    this.addMovieForm = this.formBuilder.group({
      movieName: ['', [Validators.required, Validators.maxLength(25)]],
      genre: ['', Validators.required],
      movieDescription: ['', [Validators.required, Validators.minLength(10)]],
      ticketValue: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      // movieCode: [
      //   '',
      //   [
      //     Validators.required,
      //     Validators.minLength(4),
      //     Validators.maxLength(25),
      //   ],
      // ],
    });
    this.resourceService.getAllResources().subscribe((response: any) => {
      this.resources = response;
      const categories = this.resources.filter(
        (resources) => resources.resourceCode === 'genre'
      );
      const final = categories.map((categories) => categories.resourceDetail);
      this.genres = final;
    });
  }

  addMovie() {
    if (this.addMovieForm.invalid) {
      return this.notifyService.showError('All fields are Mandatory', 'Movie Plan');
    }
    const id = 0;
    const movieName = this.addMovieForm.controls['movieName'].value;
    const genre = this.addMovieForm.controls['genre'].value;
    const movieDescription = this.addMovieForm.controls['movieDescription'].value;
    const ticketValue = this.addMovieForm.controls['ticketValue'].value;
    // const movieCode = this.addMovieForm.controls['movieCode'].value;
    const body: Movie = {
      id: id,
      movieName: movieName,
      genre: genre,
      movieDescription: movieDescription,
      ticketValue: ticketValue,
      // movieCode: movieCode,
    };
    this.movieService.addMovie(body).subscribe(
      (data: any) => {
        this.notifyService.showSuccess(
          'Movie Added Successfully',
          'Movie Plan'
        );
        this.router.navigate(['/home/movies']);
      },
      (err) => {
        this.notifyService.showSuccess(
          'Movie already exist or something went wrong',
          'Try again'
        );
      }
    );
  }

  cancel() {
    this.notifyService.showWarn('Movie was not added', 'Cancelled');
    this.router.navigate(['/home']);
  }

}
