package kma.practice.eambulance.service;

import kma.practice.eambulance.dto.CredentialsDto;

import java.util.List;

public interface CredentialsService {

    CredentialsDto create(CredentialsDto credentialsDto);
    CredentialsDto readById(long id);
    CredentialsDto update(CredentialsDto credentialsDto);
    void delete(long id);
    List<CredentialsDto> getAll();
}
