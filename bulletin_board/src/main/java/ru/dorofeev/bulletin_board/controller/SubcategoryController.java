package ru.dorofeev.bulletin_board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.dorofeev.bulletin_board.model.base.Photo;
import ru.dorofeev.bulletin_board.model.base.Subcategory;
import ru.dorofeev.bulletin_board.service.interf.SubcategoryService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/subcategory")
public class SubcategoryController implements AbstractObjectDataController<Subcategory> {
    private final SubcategoryService subcategoryService;

    @Autowired
    public SubcategoryController(SubcategoryService subcategoryService) {
        this.subcategoryService = subcategoryService;
    }

    @GetMapping("list")
    @Override
    public List<Subcategory> getAll() {
        return subcategoryService.findALl();
    }

    @GetMapping("find/{id}")
    @Override
    public Optional<Subcategory> getById(@PathVariable Long id) {
        return subcategoryService.findById(id);
    }

    @GetMapping("find_by_name/{name}")
    @Override
    public List<Subcategory> getByName(@PathVariable String name) {
        return subcategoryService.findAllByName(name);
    }

    @PostMapping("add")
    @Override
    public void add(@Valid @RequestBody Subcategory subcategory) {
        subcategoryService.save(subcategory);
    }

    @DeleteMapping("delete/{id}")
    @Override
    public void delete(@PathVariable Long id) {
        subcategoryService.deleteById(id);
    }

    @PutMapping("update")
    @Override
    public void update(@RequestBody Subcategory subcategory) {
        subcategoryService.update(subcategory);
    }
}
