package ru.dorofeev.bulletin_board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.dorofeev.bulletin_board.dto.AdvertisementDto;
import ru.dorofeev.bulletin_board.mapper.AdvertisementMapperCustom;
import ru.dorofeev.bulletin_board.model.base.Advertisement;
import ru.dorofeev.bulletin_board.service.interf.AdvertisementService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/advertisement")
@RequiredArgsConstructor
public class AdvertisementController implements AbstractObjectDataController<AdvertisementDto>{
    private final AdvertisementService advertisementService;

    @GetMapping()
    public List<AdvertisementDto> getAll() {
        return AdvertisementMapperCustom.toAdvertisementDtoList(advertisementService.findALl());
    }

    @GetMapping("/{id}")
    @Override
    public Optional<AdvertisementDto> getById(@PathVariable Long id) {
        Optional<Advertisement> byId = advertisementService.findById(id);
        Advertisement advertisement = new Advertisement();
        if (byId.isPresent()) {
            advertisement = byId.get();
        }

        return Optional.ofNullable(AdvertisementMapperCustom.toAdvertisementDto(advertisement));
    }

    @GetMapping("/name/{name}")
    @Override
    public List<AdvertisementDto> getByName(@PathVariable String name) {
        return AdvertisementMapperCustom.toAdvertisementDtoList(advertisementService.findAllByName(name));
    }

    @PostMapping("/add")
    @Override
    public void add(@RequestBody AdvertisementDto advertisement) {
        Advertisement advertisement1 = AdvertisementMapperCustom.toAdvertisement(advertisement);

        advertisementService.save(advertisement1);
    }

    @DeleteMapping("/{id}")
    @Override
    public void delete(@PathVariable Long id) {
        advertisementService.deleteById(id);
    }

    @PutMapping()
    @Override
    public void update(@RequestBody AdvertisementDto advertisement) {
        advertisementService.update(AdvertisementMapperCustom.toAdvertisement(advertisement));
    }
}
