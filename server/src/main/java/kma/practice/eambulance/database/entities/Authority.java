package kma.practice.eambulance.database.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "authority")
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "password")
    private String password;

    @Override
    public String getAuthority() {
        return login;
    }
}
