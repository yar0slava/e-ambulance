package kma.practice.eambulance.database.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
@Entity

@Table(name = "crews")
public class CrewEntity {

    @Id
    @Column(name = "tab_number")
    private long tabNumber;


    @Column(name = "members")
    @NotBlank(message = "The members cannot be empty")
    private String members;


    @Column(name = "car_number")
    @Pattern(regexp="(^$|[0-9]{3,4})")
    @NotBlank(message = "The car_number cannot be empty")
    private String carNumber;

    @Column(name = "location")
    private String location;


    @Column(name = "availability")
    @Enumerated(EnumType.STRING)
    private Availability availability;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "credentials_id")
    private CredentialsEntity credentials;
}
