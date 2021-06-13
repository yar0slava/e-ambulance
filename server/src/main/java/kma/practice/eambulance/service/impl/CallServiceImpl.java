package kma.practice.eambulance.service.impl;


import kma.practice.eambulance.database.entities.CallEntity;
import kma.practice.eambulance.database.repositories.CallsRepository;
import kma.practice.eambulance.service.CallService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CallServiceImpl implements CallService {

    private final CallsRepository callsRepository;

    public CallServiceImpl(CallsRepository callsRepository){
        this.callsRepository = callsRepository;
    }

    @Override
    public CallEntity create(CallEntity callEntity) {
        return callsRepository.save(callEntity);
    }

    @Override
    public CallEntity readById(long id) {
        Optional<CallEntity> optional = callsRepository.findById(id);
            return optional.orElse(null);
    }

    @Override
    public CallEntity update(CallEntity callEntity) {
        return callsRepository.save(callEntity);
    }

    @Override
    public void delete(long id) {
         CallEntity callEntity = readById(id);
         callsRepository.delete(callEntity);
    }

    @Override
    public List<CallEntity> getAll() {
        List<CallEntity> callEntities = (List<CallEntity>) callsRepository.findAll();
        return callEntities.isEmpty() ? new ArrayList<>() :callEntities;
    }
}
