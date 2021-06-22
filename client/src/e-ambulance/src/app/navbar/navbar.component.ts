import { Component, OnInit } from '@angular/core';
import {LocalStorageService} from "../local-storage.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  public authority: string | null | undefined;

  constructor(private localStorageService: LocalStorageService) { }

  private getAuthority(): void{
    this.authority = this.localStorageService.get('authority');
  }

  ngOnInit(): void {
    console.log(this.authority);
    this.getAuthority();
  }
}
