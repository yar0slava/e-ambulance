package kma.practice.eambulance.database.entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@Entity


@Table(name = "calls")
public class CallEntity {

    // автоматича генерація паролю
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


    @Column(name = "date_time")
    private LocalDateTime dateTime;

    // автоматичне створення часу
    @PrePersist
    protected void onCreate() {
        dateTime = LocalDateTime.now();
    }


    @Column(name = "address")
    @NotBlank(message = "The address cannot be empty")
    private String address;

    @NotBlank(message = "The reason cannot be empty")
    @Size(min = 4, max = 5000)
    @Column(name = "reason")
    private String reason;


    @Column(name = "phone_number")
    @Pattern(regexp="(^$|[0-9]{10})")
    @NotBlank(message = "The phone cannot be empty")
    private String phoneNumber;

    @Column(name = "patient_condition")
    private String patientCondition;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CallStatus status;

    @NotBlank(message = "The report cannot be empty")
    @Column(name = "report")
    private String report;

    @ManyToOne
    @JoinColumn(name = "crew_id")
    private CrewEntity crew;

    @ManyToOne
    @JoinColumn(name = "dispatcher_id")
    private DispatcherEntity dispatcher;

}
