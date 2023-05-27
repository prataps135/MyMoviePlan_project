import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { UserRegistrationComponent } from './components/user-registration/user-registration.component';
import { MovieListComponent } from './components/movie-list/movie-list.component';
import { AddMovieComponent } from './components/add-movie/add-movie.component';
import { AdminRegistrationComponent } from './components/admin-registration/admin-registration.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'user-reg', component: UserRegistrationComponent },
  {
    path: 'home',
    component: DashboardComponent,
    children: [
      { path: 'movies', component: MovieListComponent },
      { path: 'add-movie', component: AddMovieComponent },
      //{ path: 'view-product/:pid', component: ViewProductComponent },
      //{ path: 'update-product/:pid', component: UpdateProductComponent },
      { path: 'admin-reg', component: AdminRegistrationComponent },
      { path: 'user-reg', component: UserRegistrationComponent }
    ],
  },
  // { path: '**', redirectTo: '/home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
