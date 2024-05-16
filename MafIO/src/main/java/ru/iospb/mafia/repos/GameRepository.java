package ru.iospb.mafia.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.iospb.mafia.model.Game;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Long> {
    List<Game> findAll();
}
