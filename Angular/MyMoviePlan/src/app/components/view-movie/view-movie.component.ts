import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Movie } from 'src/app/model/Movie';
import { AuthenticationService } from 'src/app/services/Authentication/authentication.service';
import { MovieService } from 'src/app/services/Movie/movie.service';
import { NotificationService } from 'src/app/services/Notification/notification.service';

@Component({
  selector: 'app-view-movie',
  templateUrl: './view-movie.component.html',
  styleUrls: ['./view-movie.component.scss']
})
export class ViewMovieComponent {
  mid: number;
  currentMovie: Movie;
  roleAdmin: any = {};
  roleCustomer: any = {};

  constructor(
    private route: ActivatedRoute,
    private movieService: MovieService,
    private router: Router,
    private authService: AuthenticationService,
    private notifyService: NotificationService
  ) {}

  ngOnInit() {
    this.route.params.subscribe((params) => (this.mid = +params['mid']));
    this.movieService
      .getMovieById(this.mid)
      .subscribe(
        (res: any) => (
          (this.currentMovie = res), console.log(this.currentMovie)
        )
      );

    this.authService
      .getType()
      .subscribe((role: any) => (this.roleAdmin = role));

    this.authService
      .getType()
      .subscribe((roles: any) => (this.roleCustomer = roles));
  }

  deleteMovie(mid: number) {
    this.movieService.deleteMovieById(mid).subscribe(
      (res: any) => {
        this.notifyService.showSuccess(
          'Movie deleted successfully',
          'Movie Plan'
        );
        this.router.navigate(['home/movies']);
      },
      (err) => {
        this.notifyService.showError('Movie was not deleted', 'Try again');
      }
    );
  }

  updateMovie(mid: number) {
    this.router.navigate(['home/update-movie/' + mid]);
  }

  cancel() {
    this.notifyService.showWarn('going to available movies', 'Cancelled');
    this.router.navigate(['home/movies']);
  }

  purchase() {
    this.router.navigate(['/payment-Summary']);
  }

}
