import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Movie } from 'src/app/model/Movie';
import { Resource } from 'src/app/model/Resource';
import { MovieService } from 'src/app/services/Movie/movie.service';
import { NotificationService } from 'src/app/services/Notification/notification.service';
import { MovieResourceService } from 'src/app/services/movie-resource/movie-resource.service';

@Component({
  selector: 'app-update-movie',
  templateUrl: './update-movie.component.html',
  styleUrls: ['./update-movie.component.scss']
})
export class UpdateMovieComponent {
  mid: number;
  movie: Movie;
  genres: any;
  resources: Resource[] = [];
  updateMovieForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private movieService: MovieService,
    private router: Router,
    private route: ActivatedRoute,
    private movieResourceService: MovieResourceService,
    private notifyService: NotificationService
  ) { }

  ngOnInit() {
    this.updateMovieForm = this.formBuilder.group({
      mname: ['', [Validators.required, Validators.maxLength(25)]],
      cast: ['', [Validators.required, Validators.minLength(10)]],
      director: [
        '',
        [
          Validators.required,
          Validators.pattern('[a-zA-Z][a-zA-Z ]+'),
          Validators.minLength(3),
          Validators.maxLength(20),
        ],
      ],
      mgenre: ['', Validators.required],
      mdesc: ['', [Validators.required, Validators.minLength(10)]],
      language: [
        '',
        [
          Validators.required,
          Validators.pattern('[a-zA-Z][a-zA-Z ]+'),
          Validators.minLength(3),
          Validators.maxLength(20),
        ],
      ],
      runTime: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      ticketPrice: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      movieCode: [
        '',
        [
          Validators.required,
          Validators.minLength(4),
          Validators.maxLength(25),
        ],
      ],
    });

    this.movieResourceService.getAllResources().subscribe((response: any) => {
      this.resources = response;
      const categories = this.resources.filter(
        (resources) => resources.resourceCode === 'genre'
      );
      const final = categories.map((genre) => genre.resourceDetail);
      this.genres = final;
    });

    this.route.params.subscribe((params) => (this.mid = +params['mid']));
    this.movieService.getMovieById(this.mid).subscribe((resp: any) => {
      this.movie = resp;
      this.updateMovieForm.controls['mname'].setValue(resp.mname);
      this.updateMovieForm.controls['cast'].setValue(resp.cast);
      this.updateMovieForm.controls['director'].setValue(resp.director);
      this.updateMovieForm.controls['mgenre'].setValue(resp.mgenre);
      this.updateMovieForm.controls['mdesc'].setValue(resp.mdesc);
      this.updateMovieForm.controls['language'].setValue(resp.language);
      this.updateMovieForm.controls['runTime'].setValue(resp.runTime);
      this.updateMovieForm.controls['ticketPrice'].setValue(resp.ticketPrice);
      this.updateMovieForm.controls['movieCode'].setValue(resp.movieCode);
    });
  }

  updateMovie() {
    const mid = 0;
    const mname = this.updateMovieForm.controls['mname'].value;
    const cast = this.updateMovieForm.controls['cast'].value;
    const director = this.updateMovieForm.controls['director'].value;
    const mgenre = this.updateMovieForm.controls['mgenre'].value;
    const mdesc = this.updateMovieForm.controls['mdesc'].value;
    const language = this.updateMovieForm.controls['language'].value;
    const runTime = this.updateMovieForm.controls['runTime'].value;
    const ticketPrice = this.updateMovieForm.controls['ticketPrice'].value;
    const movieCode = this.updateMovieForm.controls['movieCode'].value;
    const body: Movie = {
      id: mid,
      movieName: mname,
      genre: mgenre,
      movieDescription: mdesc,
      ticketValue: ticketPrice,
      // movieCode: movieCode,
    };
    this.movieService.updateMovie(this.mid, body).subscribe(
      (data: any) => {
        this.notifyService.showSuccess(
          'Movie Updated successfully',
          'Medicare'
        );
        this.router.navigate(['/home/movies']);
      },
      (err) => {
        this.notifyService.showError('Movie cannot update', 'Try again');
      }
    );
  }

  cancel() {
    this.notifyService.showWarn('Movie was not updated', 'Cancelled');
    this.router.navigate(['home/movies']);
  }

}
