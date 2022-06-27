package ru.dorofeev.bulletin_board.service.impl;

import org.springframework.stereotype.Service;
import ru.dorofeev.bulletin_board.model.base.Address;
import ru.dorofeev.bulletin_board.repository.AddressRepository;
import ru.dorofeev.bulletin_board.service.interf.AddressService;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findALl() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public Optional<Address> save(Address address) {
        return Optional.of(addressRepository.save(address));
    }

    @Override
    public void update(Address address) {
        addressRepository.save(address);
    }

    @Override
    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }
}
