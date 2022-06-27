package ru.dorofeev.bulletin_board.service.impl;

import org.springframework.stereotype.Service;
import ru.dorofeev.bulletin_board.model.base.Subcategory;
import ru.dorofeev.bulletin_board.repository.SubcategoryRepository;
import ru.dorofeev.bulletin_board.service.interf.SubcategoryService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {
   private final SubcategoryRepository subcategoryRepository;

    public SubcategoryServiceImpl(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }

    @Override
    public List<Subcategory> findALl() {
        return subcategoryRepository.findAll();
    }

    @Override
    public Optional<Subcategory> findById(Long id) {
        return subcategoryRepository.findById(id);
    }

    @Override
    public List<Subcategory> findAllByName(String name) {
        if (name == null) {
            return Collections.emptyList();
        }

        return subcategoryRepository.findAllByName(name);
    }

    @Override
    public Optional<Subcategory> save(Subcategory subcategory) {
        return Optional.of(subcategoryRepository.save(subcategory));
    }

    @Override
    public void update(Subcategory subcategory) {
        subcategoryRepository.save(subcategory);
    }

    @Override
    public void deleteById(Long id) {
        subcategoryRepository.deleteById(id);
    }

}
