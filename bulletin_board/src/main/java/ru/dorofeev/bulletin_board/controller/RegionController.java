package ru.dorofeev.bulletin_board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.dorofeev.bulletin_board.model.base.Region;
import ru.dorofeev.bulletin_board.service.interf.RegionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/region")
public class RegionController implements AbstractController<Region> {
    private final RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("list")
    @Override
    public List<Region> getAll() {
        return regionService.findALl();
    }

    @GetMapping("find/{id}")
    @Override
    public Optional<Region> getById(@PathVariable Long id) {
        return regionService.findById(id);
    }

    @PostMapping("add")
    @Override
    public void add(@RequestBody Region region) {
        regionService.save(region);
    }

    @DeleteMapping("delete")
    @Override
    public void delete(@PathVariable Long id) {
        regionService.deleteById(id);
    }

    @PutMapping("update")
    @Override
    public void update(@PathVariable Region region) {
        regionService.update(region);
    }
}
