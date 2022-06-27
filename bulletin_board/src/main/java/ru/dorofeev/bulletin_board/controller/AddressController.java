package ru.dorofeev.bulletin_board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.dorofeev.bulletin_board.model.base.Address;
import ru.dorofeev.bulletin_board.service.interf.AddressService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController implements AbstractController<Address> {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("list")
    @Override
    public List<Address> getAll() {
        return addressService.findALl();
    }

    @GetMapping("find/{id}")
    @Override
    public Optional<Address> getById(@PathVariable Long id) {
        return addressService.findById(id);
    }

    @PostMapping("add")
    @Override
    public void add(@RequestBody Address address) {
        addressService.save(address);
    }

    @DeleteMapping("delete")
    @Override
    public void delete(@PathVariable Long id) {
        addressService.deleteById(id);
    }

    @PutMapping("update")
    @Override
    public void update(@PathVariable Address address) {
        addressService.update(address);
    }
}
