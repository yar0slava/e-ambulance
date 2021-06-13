package kma.practice.eambulance.dto;

import kma.practice.eambulance.database.entities.CredentialsEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DispatcherDto {

    private long tabNumber;
    private String fullName;
    private CredentialsEntity credentials;
}
