package ru.iospb.mafia.repos;

import org.springframework.data.repository.CrudRepository;
import ru.iospb.mafia.model.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends CrudRepository<Player, Long> {
    public List<Player> findAll();
    Optional<Player> findByNickname(String nickname);
}
