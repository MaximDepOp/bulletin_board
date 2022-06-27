package ru.dorofeev.bulletin_board.dto;

import lombok.Data;

@Data
public class AuthenticationRequestDto {
    private String login;
    private String password;
}
