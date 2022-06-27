package ru.dorofeev.bulletin_board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dorofeev.bulletin_board.model.base.Locality;

@Repository
public interface LocalityRepository extends JpaRepository<Locality, Long> {

}
