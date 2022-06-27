package ru.dorofeev.bulletin_board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.dorofeev.bulletin_board.model.base.Locality;
import ru.dorofeev.bulletin_board.service.interf.LocalityService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/locality")
public class LocalityController implements AbstractController<Locality> {
    private final LocalityService localityService;

    @Autowired
    public LocalityController(LocalityService localityService) {
        this.localityService = localityService;
    }

    @GetMapping("list")
    @Override
    public List<Locality> getAll() {
        return localityService.findALl();
    }

    @GetMapping("find/{id}")
    @Override
    public Optional<Locality> getById(@PathVariable Long id) {
        return localityService.findById(id);
    }

    @PostMapping("add")
    @Override
    public void add(@RequestBody Locality locality) {
        localityService.save(locality);
    }

    @DeleteMapping("delete")
    @Override
    public void delete(@PathVariable Long id) {
        localityService.deleteById(id);
    }

    @PutMapping("update")
    @Override
    public void update(@PathVariable Locality locality) {
        localityService.update(locality);
    }
}
