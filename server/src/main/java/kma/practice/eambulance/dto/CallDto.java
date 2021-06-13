package kma.practice.eambulance.dto;

import kma.practice.eambulance.database.entities.CallStatus;
import kma.practice.eambulance.database.entities.CrewEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
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
}
