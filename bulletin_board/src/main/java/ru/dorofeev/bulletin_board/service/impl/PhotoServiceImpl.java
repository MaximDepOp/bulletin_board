package ru.dorofeev.bulletin_board.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dorofeev.bulletin_board.model.base.Photo;
import ru.dorofeev.bulletin_board.repository.PhotoRepository;
import ru.dorofeev.bulletin_board.service.interf.AbstractObjectDataService;
import ru.dorofeev.bulletin_board.service.interf.PhotoService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PhotoServiceImpl implements PhotoService {
    private final PhotoRepository photoRepository;

    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public List<Photo> findAllByName(String name) {
        if (name == null) {
            return Collections.emptyList();
        }

        return photoRepository.findAllByName(name);
    }

    @Override
    public List<Photo> findALl() {
        return photoRepository.findAll();
    }

    @Override
    public Optional<Photo> findById(Long id) {
        return photoRepository.findById(id);
    }

    @Override
    public Optional<Photo> save(Photo photo) {
        return Optional.of(photoRepository.save(photo));
    }

    @Override
    public void update(Photo photo) {
        Optional<Photo> row = photoRepository.findById(photo.getId());

        if (row.isPresent()) {
            photoRepository.save(photo);
        }
    }

    @Override
    public void deleteById(Long id) {
        photoRepository.deleteById(id);
    }
}
