package kma.practice.eambulance.service.impl;

import kma.practice.eambulance.database.entities.DispatcherEntity;
import kma.practice.eambulance.database.repositories.DispatchersRepository;
import kma.practice.eambulance.dto.DispatcherDto;
import kma.practice.eambulance.mappers.DispatcherMapper;
import kma.practice.eambulance.service.DispatcherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DispatcherServiceImpl implements DispatcherService {

    private final DispatchersRepository dispatchersRepository;
    private final DispatcherMapper dispatcherMapper;

    public DispatcherServiceImpl(DispatchersRepository dispatchersRepository, DispatcherMapper dispatcherMapper) {
        this.dispatchersRepository = dispatchersRepository;
        this.dispatcherMapper = dispatcherMapper;
    }

    @Override
    public DispatcherDto create(DispatcherDto dispatcherDto) {
        return dispatcherMapper.toDto(dispatchersRepository.save(dispatcherMapper.toEntity(dispatcherDto)));
    }

    @Override
    public DispatcherDto readById(long id) {
        Optional<DispatcherEntity> optional = dispatchersRepository.findById(id);
        return dispatcherMapper.toDto(optional.orElse(null));
    }

    @Override
    public DispatcherDto update(DispatcherDto dispatcherDto) {
        return dispatcherMapper.toDto(dispatchersRepository.save(dispatcherMapper.toEntity(dispatcherDto)));
    }

    @Override
    public void delete(long id) {
        dispatchersRepository.deleteById(id);
    }

    @Override
    public List<DispatcherDto> getAll() {
        return dispatchersRepository.findAll().stream()
                .map(dispatcherMapper::toDto)
                .collect(Collectors.toList());
    }

    public long getTabNumberByLogin(String login){
        System.out.println(dispatchersRepository.findByCredentials_Login(login));
        return dispatchersRepository.findByCredentials_Login(login).getTabNumber();
    }
}
