package ru.dorofeev.bulletin_board.controller;

import java.util.List;

public interface AbstractObjectDataController<T> extends AbstractController<T>{
    List<T> getByName(String name);
}
