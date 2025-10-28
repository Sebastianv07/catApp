import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../../core/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent {
  username = '';
  password = '';
  errorMessage = '';

  constructor(private auth: AuthService, private router: Router) {}

  onLogin(): void {
    this.auth.login(this.username, this.password).subscribe({
      next: () => this.router.navigate(['/profile']),
      error: () => this.errorMessage = 'Credenciales incorrectas'
    });
  }
}
