import { Component, OnInit } from '@angular/core';
import {Call} from "../models/call";
import {Crew} from "../models/crew";
import {CrewService} from "../crew.service";

@Component({
  selector: 'app-new-call',
  templateUrl: './new-call.component.html',
  styleUrls: ['./new-call.component.css']
})
export class NewCallComponent implements OnInit {

  public crewTabNums: number[] | undefined;
  public crew: Crew = {
    members: ""
  };

  public call: Call = {
    phoneNumber: "",
    address: "",
    reason: "",
    patientCondition: "",
    crew: this.crew
  };

  constructor(private crewService: CrewService) {
  }

  private getCrewTabNums(): void {
    this.crewTabNums = this.crewService.getCrewsTabNums();
  }

  ngOnInit(): void {
    this.getCrewTabNums();
    console.log(this.crewTabNums);
  }

  public onCreate(){
    // @ts-ignore
    console.log(this.call.crew?.tabNumber);
  }
}
