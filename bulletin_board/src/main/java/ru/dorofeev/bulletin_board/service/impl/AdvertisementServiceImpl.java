package ru.dorofeev.bulletin_board.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dorofeev.bulletin_board.model.base.Advertisement;
import ru.dorofeev.bulletin_board.repository.AdvertisementRepository;
import ru.dorofeev.bulletin_board.service.interf.AdvertisementService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {
    private final AdvertisementRepository advertisementRepository;

    @Autowired
    public AdvertisementServiceImpl(AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }

    @Override
    public List<Advertisement> findALl() {
        return advertisementRepository.findAll();
    }

    @Override
    public Optional<Advertisement> findById(Long id) {
        return advertisementRepository.findById(id);
    }

    @Override
    public List<Advertisement> findAllByName(String name) {
        if (name == null) {
            return Collections.emptyList();
        }

        return advertisementRepository.findAllByName(name);
    }

    @Override
    public Optional<Advertisement> save(Advertisement advertisement) {
        return Optional.of(advertisementRepository.save(advertisement));
    }

    @Override
    public void update(Advertisement advertisement) {
        Optional<Advertisement> row = advertisementRepository.findById(advertisement.getId());

        if (row.isPresent()) {
            advertisementRepository.save(advertisement);
        }
    }

    @Override
    public void deleteById(Long id) {
        advertisementRepository.deleteById(id);
    }

}
