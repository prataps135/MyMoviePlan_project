import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { UserRegistrationComponent } from './components/user-registration/user-registration.component';
import { MovieListComponent } from './components/movie-list/movie-list.component';
import { AddMovieComponent } from './components/add-movie/add-movie.component';
import { AdminRegistrationComponent } from './components/admin-registration/admin-registration.component';
import { ViewMovieComponent } from './components/view-movie/view-movie.component';
import { UpdateMovieComponent } from './components/update-movie/update-movie.component';
import { PaymentComponent } from './components/payment/payment.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'user-reg', component: UserRegistrationComponent },
  { path: 'payment', component: PaymentComponent },
  {
    path: 'home',
    component: DashboardComponent,
    children: [
      { path: 'movies', component: MovieListComponent },
      { path: 'add-movie', component: AddMovieComponent },
      { path: 'view-movie/:id', component: ViewMovieComponent },
      { path: 'update-movie/:id', component: UpdateMovieComponent },
      { path: 'admin-reg', component: AdminRegistrationComponent },
    ],
  },
  // { path: '**', redirectTo: '/home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
