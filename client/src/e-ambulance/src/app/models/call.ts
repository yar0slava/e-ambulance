import {Crew} from "./crew";
import {Dispatcher} from "./dispatcher";

export class Call {
  id?: number;
  address?: string;
  dateTime?: string;
  patientCondition?: string;
  phoneNumber?: string;
  reason?: string;
  report?: string;
  status?: string;
  crew?: Crew;
  dispatcher?: Dispatcher;

  constructor(id: number, address: string,
  dateTime: string, patientCondition: string,
  phoneNumber: string, reason: string,
  report: string, status: string,
  crew: Crew, dispatcher: Dispatcher) {
    this.id = id;
    this.address = address;
    this.dateTime = dateTime;
    this.patientCondition = patientCondition;
    this.phoneNumber = phoneNumber;
    this.reason = reason;
    this.report = report;
    this.status = status;
    this.crew = crew;
    this.dispatcher = dispatcher;
  }

}
