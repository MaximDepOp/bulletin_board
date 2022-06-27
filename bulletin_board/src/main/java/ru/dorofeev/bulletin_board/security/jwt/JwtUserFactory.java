package ru.dorofeev.bulletin_board.security.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ru.dorofeev.bulletin_board.model.auth.Role;
import ru.dorofeev.bulletin_board.model.auth.Status;
import ru.dorofeev.bulletin_board.model.auth.Users;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class JwtUserFactory {
    public JwtUserFactory() {
    }

    public static JwtUser create(Users user) {
        return new JwtUser(
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                user.getUsername(),
                user.getPhoneNumber(),
                user.getStatus().equals(Status.ACTIVE),
                mapToGrantedAuthorities(new HashSet<>(user.getRoles()))
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(Set<Role> userRoles) {
        return userRoles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
