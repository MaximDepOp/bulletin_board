package ru.dorofeev.bulletin_board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dorofeev.bulletin_board.model.auth.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String name);
    Users findByLogin(String login);
}
