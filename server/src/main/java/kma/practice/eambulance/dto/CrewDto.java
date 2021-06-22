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

    @Override
    public String toString() {
        return "CallDto{" +
                "tabNumber=" + tabNumber +
                ", members=" + members +
                ", carNumber='" + carNumber + '\'' +
                ", location='" + location + '\'' +
                ", availability='" + availability.name() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        CrewDto object = (CrewDto) o;
        return this.tabNumber == object.tabNumber &&
                this.members.equals(object.members) &&
                this.carNumber.equals(object.carNumber) &&
                this.location.equals(object.location) &&
                this.availability.name().equals(object.availability.name()) ;
    }
}
