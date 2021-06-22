package kma.practice.eambulance.dto;

import kma.practice.eambulance.database.entities.Authority;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CredentialsDto {

    private String login;
    private String password;
    private Authority authority;
}
