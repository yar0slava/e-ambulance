package kma.practice.eambulance.service.impl;


import kma.practice.eambulance.database.entities.CallEntity;
import kma.practice.eambulance.database.repositories.CallsRepository;
import kma.practice.eambulance.dto.CallDto;
import kma.practice.eambulance.mappers.CallMapper;
import kma.practice.eambulance.service.CallService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CallServiceImpl implements CallService {

    private final CallsRepository callsRepository;
    private final CallMapper callMapper;

    public CallServiceImpl(CallsRepository callsRepository, CallMapper callMapper){
        this.callsRepository = callsRepository;
        this.callMapper = callMapper;
    }

    @Override
    public CallDto create(CallEntity callEntity) {
        return callMapper.toDto(callsRepository.save(callEntity));
    }

    @Override
    public CallDto readById(long id) {
        Optional<CallEntity> optional = callsRepository.findById(id);
            return callMapper.toDto(optional.orElse(null));
    }

    @Override
    public CallDto update(CallEntity callEntity) {
        return callMapper.toDto(callsRepository.save(callEntity));
    }

    @Override
    public void delete(long id) {
         callsRepository.deleteById(id);
    }

    @Override
    public List<CallDto> getAll() {
        return callsRepository.findAll().stream()
                .map(callMapper::toDto)
                .collect(Collectors.toList());
    }
}
