package kma.practice.eambulance.database.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity

@Table(name = "calls")
public class CallEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "address")
    private String address;

    @Column(name = "reason")
    private String reason;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "patient_condition")
    private String patientCondition;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CallStatus status;

    @Column(name = "report")
    private String report;

    @Column(name = "crew")
    @ManyToOne
    @JoinColumn(name = "crew_id")
    private CrewEntity crew;

    @Column(name = "dispatcher")
    @ManyToOne
    @JoinColumn(name = "dispatcher_id")
    private DispatcherEntity dispatcher;
}
