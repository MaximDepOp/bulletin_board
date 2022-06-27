package ru.dorofeev.bulletin_board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.dorofeev.bulletin_board.model.base.Category;
import ru.dorofeev.bulletin_board.model.base.Subcategory;
import ru.dorofeev.bulletin_board.service.interf.CategoryService;
import ru.dorofeev.bulletin_board.service.interf.SubcategoryService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController implements AbstractObjectDataController<Category> {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("list")
    @Override
    public List<Category> getAll() {
        return categoryService.findALl();
    }

    @GetMapping("find/{id}")
    @Override
    public Optional<Category> getById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @GetMapping("find_by_name/{name}")
    @Override
    public List<Category> getByName(@PathVariable String name) {
        return categoryService.findAllByName(name);
    }

    @PostMapping("add")
    @Override
    public void add(@Valid @RequestBody Category category) {
        categoryService.save(category);
    }

    @DeleteMapping("delete/{id}")
    @Override
    public void delete(@PathVariable Long id) {
        categoryService.deleteById(id);
    }

    @PutMapping("update")
    @Override
    public void update(@RequestBody Category category) {
        categoryService.update(category);
    }
}
