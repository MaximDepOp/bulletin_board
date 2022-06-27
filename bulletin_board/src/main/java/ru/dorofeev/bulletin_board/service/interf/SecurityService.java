package ru.dorofeev.bulletin_board.service.interf;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String name, String password);
}
