package ru.iospb.mafia.repos;

import org.springframework.data.repository.CrudRepository;
import ru.iospb.mafia.model.Player;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Long> {
    public List<Player> findAll();
}
