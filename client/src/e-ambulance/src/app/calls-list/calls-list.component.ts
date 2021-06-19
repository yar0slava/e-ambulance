import { Component, OnInit } from '@angular/core';
import {Call} from "../models/call";
import {CallService} from "../call.service";

@Component({
  selector: 'app-calls-list',
  templateUrl: './calls-list.component.html',
  styleUrls: ['./calls-list.component.css']
})
export class CallsListComponent implements OnInit {

  public calls: Call[] | undefined;

  constructor(private callService: CallService) {
  }

  private getCalls(): void {
    this.callService.getCalls()
      .subscribe(calls =>this.calls = calls);
  }

  ngOnInit(): void {
    this.getCalls();
  }

}
