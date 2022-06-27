package ru.dorofeev.bulletin_board.service.interf;

import java.util.List;

public interface AbstractObjectDataService<T> extends AbstractService<T> {
    List<T> findAllByName(String name);
}
