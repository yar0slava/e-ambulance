import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';
import {LocalStorageService} from "./local-storage.service";

@Injectable({
  providedIn: 'root'
})
export class UniversalAppInterceptor implements HttpInterceptor {

  constructor( private localStorageService: LocalStorageService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    const token = this.localStorageService.get('JWTToken');
    req = req.clone({
      url:  req.url,
      setHeaders: {
        Authorization: 'Bearer ${token}'
      }
    });
    return next.handle(req);
  }
}
