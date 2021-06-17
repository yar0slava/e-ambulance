package kma.practice.eambulance.service;

import kma.practice.eambulance.dto.CrewDto;

import java.util.List;

public interface CrewService {
    CrewDto create(CrewDto crewDto);
    CrewDto readById(long id);
    CrewDto update(CrewDto crewDto);
    void delete(long id);
    List<CrewDto> getAll();
}
