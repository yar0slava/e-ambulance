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

    @Override
    public String toString() {
        return "CallDto{" +
                "tabNumber=" + tabNumber +
                ", fullName=" + fullName +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        DispatcherDto object = (DispatcherDto) o;
        return this.tabNumber == object.tabNumber &&
                this.fullName.equals(object.fullName);
    }
}
