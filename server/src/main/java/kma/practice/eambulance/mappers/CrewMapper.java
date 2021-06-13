package kma.practice.eambulance.mappers;

import kma.practice.eambulance.database.entities.CallEntity;
import kma.practice.eambulance.database.entities.CrewEntity;
import kma.practice.eambulance.dto.CallDto;
import kma.practice.eambulance.dto.CrewDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CrewMapper {

    private final ModelMapper mapper;

    public CrewMapper(ModelMapper modelMapper){
        this.mapper = modelMapper;
    }

    public CrewDto toDto(CrewEntity crewEntity){
        return Objects.isNull(crewEntity) ? null : mapper.map(crewEntity, CrewDto.class);
    }

    public CrewEntity toEntity(CrewDto crewDto){
        return Objects.isNull(crewDto) ? null : mapper.map(crewDto, CrewEntity.class);
    }
}
