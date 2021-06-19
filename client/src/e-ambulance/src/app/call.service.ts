import {Injectable} from '@angular/core';
import {Call} from "./models/call";
import {CALLS} from "./mock-calls";
import {Observable, of} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CallService {

  constructor() {
  }

  public getCalls(): Observable<Call[]> {
    return of(CALLS);
  }

  public getCall(id: number) {
    return of(CALLS.find(call => call.id === id));
  }
}
