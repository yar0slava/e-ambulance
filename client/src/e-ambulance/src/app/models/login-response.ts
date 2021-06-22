export class LoginResponse{
  token: string;
  authority: string;
  tabNumber: number;

  constructor(token: string, authority: string, tabNumber: number) {
    this.token = token;
    this.authority = authority;
    this.tabNumber = tabNumber;
  }
}
