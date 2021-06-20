package kma.practice.eambulance.service.impl;

import kma.practice.eambulance.database.entities.CredentialsEntity;
import kma.practice.eambulance.database.repositories.CredentialsRepository;
import kma.practice.eambulance.dto.CredentialsDto;
import kma.practice.eambulance.mappers.CredentialsMapper;
import kma.practice.eambulance.service.CredentialsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CredentialsServiceImpl implements CredentialsService, UserDetailsService {

    private final CredentialsRepository credentialsRepository;
    private final CredentialsMapper credentialsMapper;

    public CredentialsServiceImpl(CredentialsRepository credentialsRepository, CredentialsMapper credentialsMapper) {
        this.credentialsRepository = credentialsRepository;
        this.credentialsMapper = credentialsMapper;
    }

    @Override
    public CredentialsDto create(CredentialsDto credentialsDto) {
        return credentialsMapper.toDto(credentialsRepository.save(credentialsMapper.toEntity(credentialsDto)));
    }

    @Override
    public CredentialsDto readById(long id) {
        Optional<CredentialsEntity> optional = credentialsRepository.findById(id);
        return credentialsMapper.toDto(optional.orElse(null));
    }

    @Override
    public CredentialsDto update(CredentialsDto credentialsDto) {
        return credentialsMapper.toDto(credentialsRepository.save(credentialsMapper.toEntity(credentialsDto)));
    }

    @Override
    public void delete(long id) {
        credentialsRepository.deleteById(id);
    }

    @Override
    public List<CredentialsDto> getAll() {
        return credentialsRepository.findAll().stream()
                .map(credentialsMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<CredentialsEntity> optional = credentialsRepository.findByLogin(login);
        return optional.orElse(null);
    }
}
