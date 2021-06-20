import {Injectable} from '@angular/core';
import {Call} from "./models/call";
import {Observable, of} from "rxjs";
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CallService {

  private callsUrl = 'http://localhost:8080/calls';

  constructor( private http: HttpClient) {
  }

  public getCalls(): Observable<Call[]> {
    return this.http.get<Call[]>(this.callsUrl+'/all');
  }

  public getCall(id: number) {
    return this.http.get<Call>(this.callsUrl+'/'+id);
  }

  public saveCall(call: Call) {
    return this.http.post<Call>(this.callsUrl, JSON.stringify(call));
  }
}
