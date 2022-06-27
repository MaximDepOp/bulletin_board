package ru.dorofeev.bulletin_board.service.impl;

import org.springframework.stereotype.Service;
import ru.dorofeev.bulletin_board.model.base.Street;
import ru.dorofeev.bulletin_board.repository.StreetRepository;
import ru.dorofeev.bulletin_board.service.interf.StreetService;

import java.util.List;
import java.util.Optional;

@Service
public class StreetServiceImpl implements StreetService {
    private final StreetRepository streetRepository;

    public StreetServiceImpl(StreetRepository streetRepository) {
        this.streetRepository = streetRepository;
    }

    @Override
    public List<Street> findALl() {
        return streetRepository.findAll();
    }

    @Override
    public Optional<Street> findById(Long id) {
        return streetRepository.findById(id);
    }

    @Override
    public Optional<Street> save(Street street) {
        return Optional.of(streetRepository.save(street));
    }

    @Override
    public void update(Street street) {
        streetRepository.save(street);
    }

    @Override
    public void deleteById(Long id) {
        streetRepository.deleteById(id);
    }
}
