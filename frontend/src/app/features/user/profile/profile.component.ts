import { Component } from '@angular/core';
import { AuthService } from '../../../core/services/auth.service';
import { Router } from '@angular/router';
import { User } from '../../../core/models/user.model';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html'
})
export class ProfileComponent {
  user: User | null;

  constructor(private auth: AuthService, private router: Router) {
    this.user = this.auth.getUser();
  }

  logout(): void {
    this.auth.logout();
    this.router.navigate(['/login']);
  }
}
