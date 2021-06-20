package kma.practice.eambulance.mappers;

import kma.practice.eambulance.database.entities.CredentialsEntity;
import kma.practice.eambulance.dto.CredentialsDto;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CredentialsMapper {

    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public CredentialsMapper(ModelMapper modelMapper, PasswordEncoder passwordEncoder){
        this.mapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public CredentialsDto toDto(CredentialsEntity credentialsEntity){
        return Objects.isNull(credentialsEntity) ? null : mapper.map(credentialsEntity, CredentialsDto.class);
    }

    public CredentialsEntity toEntity(CredentialsDto credentialsDto){
        CredentialsEntity credentialsEntity = mapper.map(credentialsDto, CredentialsEntity.class);
        credentialsEntity.setPassword(passwordEncoder.encode(credentialsDto.getPassword()));
        return credentialsEntity;
    }
}
