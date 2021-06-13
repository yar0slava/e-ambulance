package kma.practice.eambulance.mappers;

import kma.practice.eambulance.database.entities.CallEntity;
import kma.practice.eambulance.database.entities.DispatcherEntity;
import kma.practice.eambulance.dto.CallDto;
import kma.practice.eambulance.dto.DispatcherDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DispatcherMapper {

    private final ModelMapper mapper;

    public DispatcherMapper(ModelMapper modelMapper){
        this.mapper = modelMapper;
    }

    public DispatcherDto toDto(DispatcherEntity dispatcherEntity){
        return Objects.isNull(dispatcherEntity) ? null : mapper.map(dispatcherEntity, DispatcherDto.class);
    }

    public DispatcherEntity toEntity(DispatcherDto dispatcherDto){
        return Objects.isNull(dispatcherDto) ? null : mapper.map(dispatcherDto, DispatcherEntity.class);
    }
}
