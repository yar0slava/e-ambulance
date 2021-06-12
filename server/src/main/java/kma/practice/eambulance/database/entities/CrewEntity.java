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

    @Column(name = "authority")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "authority_id")
    private Authority authority;
}
