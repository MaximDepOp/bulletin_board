package ru.dorofeev.bulletin_board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dorofeev.bulletin_board.dto.AuthenticationRequestDto;
import ru.dorofeev.bulletin_board.model.auth.Users;
import ru.dorofeev.bulletin_board.security.jwt.JwtTokenProvider;
import ru.dorofeev.bulletin_board.service.interf.UsersService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UsersService usersService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UsersService usersService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.usersService = usersService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequestDto requestDto) {
        try {
            String login = requestDto.getLogin();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, requestDto.getPassword()));
            Users user = usersService.findByLogin(login);

            if (user == null) {
                throw new UsernameNotFoundException("User with login: " + login + " not found");
            }

            String token = jwtTokenProvider.createToken(login, user.getRoles());

            Map<Object, Object> response = new HashMap<>();
            response.put("login", login);
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @PostMapping("/registration")
    public void registration(@RequestBody Users user) {
        usersService.register(user);
    }
}
