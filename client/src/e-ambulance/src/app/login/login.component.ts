import { Component, OnInit } from '@angular/core';
import {Credentials} from "../models/credentials";
import {LoginService} from "../login.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public credentials: Credentials = {};
  public error: string | undefined;

  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
  }

  public login(): void {
    this.loginService.login(this.credentials).subscribe(
      (next) => {},
      (error) => {
      this.error = 'Invalid login or password. Please try again';
    });
  }
}
