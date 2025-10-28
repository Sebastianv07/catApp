import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../../core/services/auth.service';
import { User } from '../../../core/models/user.model';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html'
})
export class RegisterComponent {
  user: User = { username: '', password: '', name: '', email: '' };

  constructor(private auth: AuthService, private router: Router) {}

  onRegister(): void {
    this.auth.register(this.user).subscribe({
      next: () => {
        alert('Usuario registrado correctamente');
        this.router.navigate(['/login']);
      },
      error: () => alert('Error al registrar')
    });
  }
}
