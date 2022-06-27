package ru.dorofeev.bulletin_board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.dorofeev.bulletin_board.model.base.Street;
import ru.dorofeev.bulletin_board.service.interf.StreetService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/street")
public class StreetController implements AbstractController<Street> {
    private final StreetService streetService;

    @Autowired
    public StreetController(StreetService streetService) {
        this.streetService = streetService;
    }

    @GetMapping("list")
    @Override
    public List<Street> getAll() {
        return streetService.findALl();
    }

    @GetMapping("find/{id}")
    @Override
    public Optional<Street> getById(@PathVariable Long id) {
        return streetService.findById(id);
    }

    @PostMapping("add")
    @Override
    public void add(@RequestBody Street street) {
        streetService.save(street);
    }

    @DeleteMapping("delete")
    @Override
    public void delete(@PathVariable Long id) {
        streetService.deleteById(id);
    }

    @PutMapping("update")
    @Override
    public void update(@PathVariable Street street) {
        streetService.update(street);
    }
}
