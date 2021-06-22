import {Injectable} from '@angular/core';
import {Call} from "./models/call";
import {Observable, of} from "rxjs";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {tap} from "rxjs/operators";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class CallService {

  private callsUrl = 'http://localhost:8080/calls';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor( private http: HttpClient,
               private router: Router) {
  }

  public getCalls(): Observable<Call[]> {
    return this.http.get<Call[]>(this.callsUrl+'/all');
  }

  public getCallsByCrew(tabNum: string): Observable<Call[]> {
    return this.http.get<Call[]>(this.callsUrl+'/crew/'+tabNum);
  }

  public getCall(id: number) {
    return this.http.get<Call>(this.callsUrl+'/'+id);
  }

  public saveCall(call: Call): Observable<any>  {
    return this.http.post<Call>(this.callsUrl, JSON.stringify(call), this.httpOptions).pipe(
      tap((call: Call) => {
        this.router.navigate(['new-call'])
      }));
  }

  public updateCall(call: Call): Observable<any>  {
    return this.http.put<Call>(this.callsUrl, JSON.stringify(call), this.httpOptions).pipe(
      tap((call: Call) => {
        // this.router.navigate(['new-call'])
      }));
  }
}
