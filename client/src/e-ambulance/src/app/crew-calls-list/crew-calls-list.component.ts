import { Component, OnInit } from '@angular/core';
import {CallService} from "../call.service";
import {Call} from "../models/call";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-crew-calls-list',
  templateUrl: './crew-calls-list.component.html',
  styleUrls: ['./crew-calls-list.component.css']
})
export class CrewCallsListComponent implements OnInit {

  public calls: Call[] | undefined;

  constructor(
    private route: ActivatedRoute,
    private callService: CallService) { }

  private getCalls(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.callService.getCallsByCrew(String(id))
      .subscribe(calls =>this.calls = calls);
  }

  ngOnInit(): void {
    this.getCalls();
  }
}
