package ru.iospb.mafia.repos;

import org.springframework.data.repository.CrudRepository;
import ru.iospb.mafia.model.PlayerGame;
import ru.iospb.mafia.model.PlayerGameKey;

public interface PlayerGameRepository extends CrudRepository<PlayerGame, PlayerGameKey> {

}
