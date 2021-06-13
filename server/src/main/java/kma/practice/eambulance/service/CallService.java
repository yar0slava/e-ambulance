package kma.practice.eambulance.service;

import kma.practice.eambulance.database.entities.CallEntity;

import java.util.List;

public interface CallService {

    CallEntity create(CallEntity callEntity);
    CallEntity readById(long id);
    CallEntity update(CallEntity callEntity);
    void delete(long id);
    List<CallEntity> getAll();

}
