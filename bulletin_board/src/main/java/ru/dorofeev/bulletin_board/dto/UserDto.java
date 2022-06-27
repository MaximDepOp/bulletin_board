package ru.dorofeev.bulletin_board.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ru.dorofeev.bulletin_board.model.auth.Users;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class UserDto {
    private Long id;
    private String username;
    private String login;
    private String phoneNumber;

    public Users toUser() {
        Users user = new Users();
        user.setId(id);
        user.setLogin(login);
        user.setUsername(username);
        user.setPhoneNumber(phoneNumber);

        return user;
    }

    public static UserDto fromUser(Users user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());
        userDto.setUsername(user.getUsername());
        userDto.setPhoneNumber(user.getPhoneNumber());

        return userDto;
    }
}

