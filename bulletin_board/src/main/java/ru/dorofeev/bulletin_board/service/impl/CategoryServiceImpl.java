package ru.dorofeev.bulletin_board.service.impl;

import org.springframework.stereotype.Service;
import ru.dorofeev.bulletin_board.model.base.Category;
import ru.dorofeev.bulletin_board.repository.CategoryRepository;
import ru.dorofeev.bulletin_board.service.interf.CategoryService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findALl() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> findAllByName(String name) {
        if (name == null) {
            return Collections.emptyList();
        }

        return categoryRepository.findAllByName(name);
    }

    @Override
    public Optional<Category> save(Category category) {
        return Optional.of(categoryRepository.save(category));
    }

    @Override
    public void update(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }


}
