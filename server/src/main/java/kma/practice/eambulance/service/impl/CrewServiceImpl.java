package kma.practice.eambulance.service.impl;

import kma.practice.eambulance.database.entities.CrewEntity;
import kma.practice.eambulance.database.repositories.CrewsRepository;
import kma.practice.eambulance.dto.CrewDto;
import kma.practice.eambulance.mappers.CrewMapper;
import kma.practice.eambulance.service.CrewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CrewServiceImpl  implements CrewService {

    private final CrewsRepository crewsRepository;
    private final CrewMapper crewMapper;

    public CrewServiceImpl(CrewsRepository crewsRepository, CrewMapper crewMapper) {
        this.crewsRepository = crewsRepository;
        this.crewMapper = crewMapper;
    }

    @Override
    public CrewDto create(CrewDto crewDto) {
        return crewMapper.toDto(crewsRepository.save(crewMapper.toEntity(crewDto)));
    }

    @Override
    public CrewDto readById(long id) {
        Optional<CrewEntity> optional = crewsRepository.findById(id);
        return crewMapper.toDto(optional.orElse(null));
    }

    @Override
    public CrewDto update(CrewDto crewDto) {
        return crewMapper.toDto(crewsRepository.save(crewMapper.toEntity(crewDto)));
    }

    @Override
    public void delete(long id) {
        crewsRepository.deleteById(id);
    }

    @Override
    public List<CrewDto> getAll() {
        return crewsRepository.findAll().stream()
                .map(crewMapper::toDto)
                .collect(Collectors.toList());
    }

    public long getTabNumberByLogin(String login){
        return crewsRepository.findByCredentials_Login(login).orElse(null).getTabNumber();
    }
}
