package kma.practice.eambulance.database.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity

@Table(name = "dispatchers")
public class DispatcherEntity {

    @Id
    @Column(name = "tab_number")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tabNumber;

    @Column(name = "full_name")
    private String fullName;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "credentials_id")
    private CredentialsEntity credentials;
}