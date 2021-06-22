import { Component, OnInit } from '@angular/core';
import {Call} from "../models/call";
import {Crew} from "../models/crew";
import {CrewService} from "../crew.service";
import {CallService} from "../call.service";
import {Dispatcher} from "../models/dispatcher";
import {LocalStorageService} from "../local-storage.service";

@Component({
  selector: 'app-new-call',
  templateUrl: './new-call.component.html',
  styleUrls: ['./new-call.component.css']
})
export class NewCallComponent implements OnInit {

  public error: string | undefined;
  public crews: Crew[] | undefined;
  public crewTabNums: number[] | undefined;
  public crew: Crew = {};
  public dispatcher: Dispatcher = {};

  public call: Call = {
    phoneNumber: "",
    address: "",
    reason: "",
    patientCondition: "",
    crew: this.crew,
    dispatcher: this.dispatcher
  };

  constructor(private crewService: CrewService,
              private callService: CallService,
              private localStorageService: LocalStorageService) {
  }

  private getCrewsAndCrewTabNums(): void{
    this.crewTabNums = this.crewService.getCrewsTabNums();
    this.crewService.getCrews()
      .subscribe(crews =>this.crews = crews);
  }

  ngOnInit(): void {
    this.getCrewsAndCrewTabNums();
    console.log(this.crewTabNums);
  }

  public onCreate(){
    // @ts-ignore
    console.log(this.call.crew?.tabNumber);
    // @ts-ignore
    this.call.dispatcher?.tabNumber = Number(this.localStorageService.get('tabNumber'));
    this.callService.saveCall(this.call).subscribe(
      (next) => {},
      (error) => {
        this.error = 'Something went wrong. Call was not saved';
      });
  }
}
