package ru.dorofeev.bulletin_board.service.interf;

import ru.dorofeev.bulletin_board.model.auth.Users;

import java.util.List;

public interface UsersService {
    void register(Users user);

    List<Users> getAll();

    Users findByUsername(String username);

    Users findByLogin(String login);

    Users findById(Long id);

    void delete(Long id);
}
