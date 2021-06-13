package kma.practice.eambulance.database.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity

@Table(name = "crews")
public class CrewEntity {

    @Id
    @Column(name = "tab_number")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tabNumber;

    @Column(name = "members")
    private String members;

    @Column(name = "car_number")
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
