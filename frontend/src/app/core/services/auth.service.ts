import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable, BehaviorSubject, tap } from 'rxjs';
import { User } from '../models/user.model';
import { environment } from '../../../environments/environment';

@Injectable({ providedIn: 'root' })
export class AuthService {
  private base = environment.apiBaseUrl + '/usuarios';
  private currentUser = new BehaviorSubject<User | null>(null);

  constructor(private http: HttpClient) {}

  login(username: string, password: string): Observable<User> {
    const params = new HttpParams().set('username', username).set('password', password);
    return this.http.get<User>(`${this.base}/login`, { params }).pipe(
      tap(u => this.currentUser.next(u))
    );
  }

  register(user: User): Observable<User> {
    // Note: backend might expect GET; change as needed
    return this.http.post<User>(`${this.base}/register`, user);
  }

  getUser(): User | null {
    return this.currentUser.value;
  }

  logout(): void {
    this.currentUser.next(null);
  }
}
