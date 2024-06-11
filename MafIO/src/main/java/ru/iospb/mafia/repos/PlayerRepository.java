package ru.iospb.mafia.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.iospb.mafia.model.Player;
import ru.iospb.mafia.rating.Row;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends CrudRepository<Player, Long> {
    public List<Player> findAll();
    Optional<Player> findByNickname(String nickname);
}
