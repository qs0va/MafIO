package ru.iospb.mafia.repos;

import org.springframework.data.repository.CrudRepository;
import ru.iospb.mafia.model.Player;

public interface PlayerRepository extends CrudRepository<Player, Long> {

}
