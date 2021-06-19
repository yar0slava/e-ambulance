import {Crew} from "./crew";
import {Dispatcher} from "./dispatcher";

export interface Call {
  id: number;
  address: string;
  dateTime: string;
  patientCondition: string;
  phoneNumber: string;
  reason: string;
  report: string;
  status: string;
  crew: Crew;
  dispatcher: Dispatcher;
}
