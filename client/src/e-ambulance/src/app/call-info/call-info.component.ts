import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {CallService} from "../call.service";
import {Call} from "../models/call";

@Component({
  selector: 'app-call-info',
  templateUrl: './call-info.component.html',
  styleUrls: ['./call-info.component.css']
})
export class CallInfoComponent implements OnInit {

  public call: Call | undefined;

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
      .subscribe(call => this.call = call);
  }
}
