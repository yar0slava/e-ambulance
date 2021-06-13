package kma.practice.eambulance.dto;

import kma.practice.eambulance.database.entities.Availability;
import kma.practice.eambulance.database.entities.CredentialsEntity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CrewDto {

    private long tabNumber;
    private String members;
    private String carNumber;
    private String location;
    private Availability availability;
    private CredentialsEntity credentials;
}
