export class LoginResponse{
  token: string;
  authority: string;

  constructor(token: string, authority: string) {
    this.token = token;
    this.authority = authority;
  }
}
