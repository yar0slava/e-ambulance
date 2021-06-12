package kma.practice.eambulance.database.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity

@Table(name = "dispatchers_admins")
public class DispatcherEntity {

    @Id
    @Column(name = "tab_number")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tabNumber;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "authority")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "authority_id")
    private Authority authority;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "user_to_authorities",
//            joinColumns = @JoinColumn(name = "tab_number"),
//            inverseJoinColumns = @JoinColumn(name = "authority_id")
//    )
//    private Set<Authority> authority;
}