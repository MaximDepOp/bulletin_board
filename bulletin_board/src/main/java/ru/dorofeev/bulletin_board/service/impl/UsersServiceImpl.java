package ru.dorofeev.bulletin_board.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.dorofeev.bulletin_board.model.auth.Role;
import ru.dorofeev.bulletin_board.model.auth.Status;
import ru.dorofeev.bulletin_board.model.auth.Users;
import ru.dorofeev.bulletin_board.repository.RoleRepository;
import ru.dorofeev.bulletin_board.repository.UsersRepository;
import ru.dorofeev.bulletin_board.service.interf.UsersService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsersServiceImpl(UsersRepository usersRepository, RoleRepository roleRepository, @Lazy BCryptPasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(Users user) {
        Role roleUser = roleRepository.findByName("ROLE_USER");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);

        Users registeredUser = usersRepository.save(user);

        log.info("IN register - user: {} successfully registered", registeredUser);
    }


    @Override
    public List<Users> getAll() {
        List<Users> usersList = usersRepository.findAll();

        log.info("IN getAll() - {} users found", usersList.size());

        return usersList;
    }

    @Override
    public Users findByUsername(String username) {
        Users findUserByUsername = usersRepository.findByUsername(username);

        log.info("IN findByUsername() - user:{} found by username: {}", findUserByUsername, username);

        return findUserByUsername;
    }

    @Override
    public Users findByLogin(String login) {
        Users findUserByLogin = usersRepository.findByLogin(login);

        log.info("IN findByLogin() - user:{} found by login: {}", findUserByLogin, login);

        return findUserByLogin;
    }

    @Override
    public Users findById(Long id) {
        Users findUser = usersRepository.findById(id).orElse(null);

        if (findUser == null) {
            log.warn("IN findById() - no user found by id: {}", id);
            return null;
        }

        log.info("IN findById() - user:{} found by id: {}", findUser, id);

        return findUser;
    }

    @Override
    public void delete(Long id) {
        usersRepository.deleteById(id);

        log.info("IN delete() - user with id: {} successfully deleted", id);
    }
}
