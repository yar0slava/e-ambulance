package kma.practice.eambulance.mappers;

import kma.practice.eambulance.database.entities.CallEntity;
import kma.practice.eambulance.dto.CallDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CallMapper {

    private final ModelMapper mapper;

    public CallMapper(ModelMapper modelMapper){
        this.mapper = modelMapper;
    }

    public CallDto toDto(CallEntity callEntity){
        return Objects.isNull(callEntity) ? null : mapper.map(callEntity, CallDto.class);
    }

    public CallEntity toEntity(CallDto callDto){
        return Objects.isNull(callDto) ? null : mapper.map(callDto, CallEntity.class);
    }
}
