package ru.dorofeev.bulletin_board.service.impl;

import org.springframework.stereotype.Service;
import ru.dorofeev.bulletin_board.model.auth.Role;
import ru.dorofeev.bulletin_board.repository.RoleRepository;
import ru.dorofeev.bulletin_board.service.interf.RoleService;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findALl() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Optional<Role> save(Role role) {
        return Optional.of(roleRepository.save(role));
    }

    @Override
    public void update(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }
}
