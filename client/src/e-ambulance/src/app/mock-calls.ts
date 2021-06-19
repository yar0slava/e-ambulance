import {Call} from "./models/call";

export const CALLS: Call[] = [
  {
    id: 1,
    address: "Nezalezhnosti str. 25, flat 16",
    dateTime: "2021-06-17T15:45:40Z",
    patientCondition: "unstable",
    phoneNumber: "063 245 98 54",
    reason: "Heart attack",
    report: "none",
    status: "WAITING_FOR_CREW",
    crew: {
      tabNumber: 123456798,
      members: "",
      carNumber: "",
      location: "",
      availability: ""
    },
    dispatcher: {
      tabNumber: 123456789,
      fullName: ""
    }
  },
  {
    id: 2,
    address: "Danchenka str. 18, flat 55",
    dateTime: "2021-06-17T17:15:40Z",
    patientCondition: "stable",
    phoneNumber: "098 564 78 52",
    reason: "stabbing stomach pains",
    report: "nothing serious, prescribed painkillers",
    status: "FINISHED",
    crew: {
      tabNumber: 123456798,
      members: "",
      carNumber: "",
      location: "",
      availability: ""
    },
    dispatcher: {
      tabNumber: 123456789,
      fullName: ""
    }
  }
];
