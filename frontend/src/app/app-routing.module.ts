import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BreedSelectComponent } from './features/breeds/breed-select/breed-select.component';
import { BreedTableComponent } from './features/breeds/breed-table/breed-table.component';
import { LoginComponent } from './features/auth/login/login.component';
import { RegisterComponent } from './features/auth/register/register.component';
import { ProfileComponent } from './features/user/profile/profile.component';
import { AuthGuard } from './shared/guards/auth.guard';

const routes: Routes = [
  { path: '', redirectTo: 'breeds', pathMatch: 'full' },
  { path: 'breeds', component: BreedSelectComponent },
  { path: 'breeds-table', component: BreedTableComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent, canActivate: [AuthGuard] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
