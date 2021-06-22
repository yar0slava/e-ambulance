import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Credentials} from "./models/credentials";
import {tap} from "rxjs/operators";
import {LoginResponse} from "./models/login-response";
import {LocalStorageService} from "./local-storage.service";
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private loginUrl = 'http://localhost:8080/login';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor( private http: HttpClient,
               private localStorageService: LocalStorageService,
               private router: Router) {
  }

  login(credentials: Credentials): Observable<any> {
    return this.http.post<LoginResponse>(this.loginUrl, credentials, this.httpOptions).pipe(
      tap((response: LoginResponse) => {
        this.localStorageService.set('JWTToken',response.token);
        this.localStorageService.set('authority',response.authority);
        this.localStorageService.set('tabNumber',String(response.tabNumber));
        this.router.navigate(['home'])
      }));
  }
}
