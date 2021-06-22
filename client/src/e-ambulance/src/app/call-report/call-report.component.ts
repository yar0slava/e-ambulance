import { Component, OnInit } from '@angular/core';
import {Call} from "../models/call";
import {ActivatedRoute} from "@angular/router";
import {CallService} from "../call.service";
import {Crew} from "../models/crew";
import {Dispatcher} from "../models/dispatcher";

@Component({
  selector: 'app-call-report',
  templateUrl: './call-report.component.html',
  styleUrls: ['./call-report.component.css']
})
export class CallReportComponent implements OnInit {

  public error: string | undefined;
  public crew: Crew = {};
  public dispatcher: Dispatcher = {};
  public call: Call = {
    crew: this.crew,
    dispatcher: this.dispatcher
  };

  constructor(
    private route: ActivatedRoute,
    private callService: CallService
  ) { }

  ngOnInit(): void {
    this.getCall();
  }

  private getCall(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.callService.getCall(id)
      .subscribe(call => {
        this.call.id = call.id;
        this.call.address = call.address;
        this.call.dateTime = call.dateTime;
        this.call.reason = call.reason;
        this.call.patientCondition = call.patientCondition;
        this.call.phoneNumber = call.phoneNumber;
        this.call.status = call.status;
        this.call.crew!.tabNumber = call.crew!.tabNumber;
        this.call.dispatcher!.tabNumber = call.dispatcher!.tabNumber;
      });
  }

  onCloseCall() {
    // @ts-ignore
    this.call.status='FINISHED';
    // @ts-ignore
    this.callService.updateCall(this.call).subscribe(
      (next) => {},
      (error) => {
        this.error = 'Something went wrong. Call was not closed';
      });
  }
}
