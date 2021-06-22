package kma.practice.eambulance.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LoginResponseDto {

    private String authority;
    private String token;
    private long tabNumber;
}
