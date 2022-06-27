package ru.dorofeev.bulletin_board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dorofeev.bulletin_board.dto.UserDto;
import ru.dorofeev.bulletin_board.model.auth.Users;
import ru.dorofeev.bulletin_board.service.interf.UsersService;

@RestController
@RequestMapping("/api/v1/admin/")
public class AdminController {
    private final UsersService usersService;

    @Autowired
    public AdminController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("users/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        Users user = usersService.findById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        UserDto userDto = UserDto.fromUser(user);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
