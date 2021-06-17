package kma.practice.eambulance.dto;

import kma.practice.eambulance.database.entities.CallStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CallDto {



    private long id;
    private LocalDateTime dateTime;
    private String address;
    private String reason;
    private String phoneNumber;
    private String patientCondition;
    private CallStatus status;
    private String report;
    private CrewDto crew;
    private DispatcherDto dispatcher;

    @Override
    public boolean equals(Object o) {
        CallDto object = (CallDto) o;
        return this.dateTime.equals(object.dateTime) &&
                this.address.equals(object.address) &&
                this.reason.equals(object.reason) &&
                this.phoneNumber.equals(object.phoneNumber) &&
                this.patientCondition.equals(object.patientCondition) &&
                this.status.equals(object.status) &&
                this.report.equals(object.report) &&
                this.crew.getTabNumber()==(object.crew.getTabNumber()) &&
                this.dispatcher.getTabNumber()==(object.dispatcher.getTabNumber());
    }


    @Override
    public String toString() {
        return "CallDto{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", address='" + address + '\'' +
                ", reason='" + reason + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", patientCondition='" + patientCondition + '\'' +
                ", status=" + status +
                ", report='" + report + '\'' +
                ", crew=" + crew +
                ", dispatcher=" + dispatcher +
                '}';
    }
}
