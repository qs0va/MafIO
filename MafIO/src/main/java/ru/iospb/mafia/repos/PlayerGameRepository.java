package ru.iospb.mafia.repos;

import org.springframework.data.repository.CrudRepository;
import ru.iospb.mafia.model.PlayerGame;

public interface PlayerGameRepository extends CrudRepository<PlayerGame, Long> {

    void deleteAllByPlayerId(Long id);
}
