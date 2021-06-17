package kma.practice.eambulance.service;

import kma.practice.eambulance.dto.DispatcherDto;

import java.util.List;

public interface DispatcherService {
    DispatcherDto create(DispatcherDto dispatcherDto);
    DispatcherDto readById(long id);
    DispatcherDto update(DispatcherDto dispatcherDto);
    void delete(long id);
    List<DispatcherDto> getAll();
}
