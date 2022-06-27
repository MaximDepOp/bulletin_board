package ru.dorofeev.bulletin_board.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.dorofeev.bulletin_board.model.auth.Users;
import ru.dorofeev.bulletin_board.security.jwt.JwtUser;
import ru.dorofeev.bulletin_board.security.jwt.JwtUserFactory;
import ru.dorofeev.bulletin_board.service.interf.UsersService;

@Slf4j
@Service
public class JwtUserDetailsService implements UserDetailsService {
    private final UsersService usersService;

    public JwtUserDetailsService(UsersService usersService) {
        this.usersService = usersService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersService.findByLogin(username);

        if (user == null) {
            throw new UsernameNotFoundException("User with login: " + username + " not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);

        log.info("IN loadUserByUsername - user with login: {} successfully loaded", username);

        return jwtUser;
    }
}
