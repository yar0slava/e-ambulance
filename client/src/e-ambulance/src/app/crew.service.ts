import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, of} from "rxjs";
import {Crew} from "./models/crew";
import {Dispatcher} from "./models/dispatcher";

@Injectable({
  providedIn: 'root'
})
export class CrewService {

  private crewUrl = 'http://localhost:8080/crews';
  private dispatcherUrl = 'http://localhost:8080/dispatchers';
  private crews: Crew[] | undefined;

  constructor( private http: HttpClient) {
  }

  public getCrews(): Observable<Crew[]> {
    console.log('crews');
    return this.http.get<Crew[]>(this.crewUrl+'/all');
  }

  public getCrewsTabNums(): number[] {
    this.http.get<Crew[]>(this.crewUrl+'/all').subscribe(value => this.crews=value);
    var tabNums: number[] = [];

    this.crews?.forEach(function (value) {
      if (value.tabNumber != null) {
        tabNums.push(value.tabNumber);
      }
    });
    console.log('tabNums');
    return tabNums;
  }

  public getCrew(id: number) {
    return this.http.get<Crew>(this.crewUrl+'/'+id);
  }

  public saveCrew(crew: Crew) {
    return this.http.post<Crew>(this.crewUrl, JSON.stringify(crew));
  }

  public saveDispatcher(dispatcher: Dispatcher) {
    return this.http.post<Dispatcher>(this.dispatcherUrl, JSON.stringify(dispatcher));
  }
}
