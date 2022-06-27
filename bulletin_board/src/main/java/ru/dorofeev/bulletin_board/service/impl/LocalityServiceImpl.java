package ru.dorofeev.bulletin_board.service.impl;

import org.springframework.stereotype.Service;
import ru.dorofeev.bulletin_board.model.base.Locality;
import ru.dorofeev.bulletin_board.repository.LocalityRepository;
import ru.dorofeev.bulletin_board.service.interf.LocalityService;

import java.util.List;
import java.util.Optional;

@Service
public class LocalityServiceImpl implements LocalityService {
    private final LocalityRepository localityRepository;

    public LocalityServiceImpl(LocalityRepository localityRepository) {
        this.localityRepository = localityRepository;
    }

    @Override
    public List<Locality> findALl() {
        return localityRepository.findAll();
    }

    @Override
    public Optional<Locality> findById(Long id) {
        return localityRepository.findById(id);
    }

    @Override
    public Optional<Locality> save(Locality locality) {
        return Optional.of(localityRepository.save(locality));
    }

    @Override
    public void update(Locality locality) {
        localityRepository.save(locality);
    }

    @Override
    public void deleteById(Long id) {
        localityRepository.deleteById(id);
    }
}
