package kma.practice.eambulance.database.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity


@Table(name = "calls")
public class CallEntity {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "role_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "10"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private long id;

    @CreatedDate
    @Column(name = "date_time", nullable = false, updatable = false)
    private LocalDateTime dateTime;

    @NotBlank(message = "The roleName cannot be empty")
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

    @ManyToOne
    @JoinColumn(name = "crew_id")
    private CrewEntity crew;

    @ManyToOne
    @JoinColumn(name = "dispatcher_id")
    private DispatcherEntity dispatcher;
}
