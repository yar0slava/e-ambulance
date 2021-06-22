package kma.practice.eambulance.service;

import kma.practice.eambulance.dto.CallDto;

import java.util.List;

public interface CallService {

    CallDto create(CallDto callDto);
    CallDto readById(long id);
    CallDto update(CallDto callDto);
    void delete(long id);
    List<CallDto> getAll();
    public List<CallDto> findByCrew(long tabNumber);
}
