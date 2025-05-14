import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private http = inject(HttpClient);
  private router = inject(Router);
  private api = 'http://localhost:8080/auth';


  login(credentials: {email: string; password: string;}) {
    return this.http.post<{token: string }>(`${this.api}/login`, credentials);
  }

  signup(data: {fullName: string; password: string; email: string;}) {
    return this.http.post(`${this.api}/signup`, data);
  }

  logout() {
    localStorage.removeItem('token');
    this.router.navigate(['/login']);
  }
  getToken() {
    return localStorage.getItem('token');
  }
  
  isAuthenticated(): boolean {
    return !!this.getToken();
  }

}
