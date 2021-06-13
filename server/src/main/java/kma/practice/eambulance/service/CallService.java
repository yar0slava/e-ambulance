package kma.practice.eambulance.service;

import kma.practice.eambulance.database.entities.CallEntity;
import kma.practice.eambulance.dto.CallDto;

import java.util.List;

public interface CallService {

    CallDto create(CallEntity callEntity);
    CallDto readById(long id);
    CallDto update(CallEntity callEntity);
    void delete(long id);
    List<CallDto> getAll();

}
