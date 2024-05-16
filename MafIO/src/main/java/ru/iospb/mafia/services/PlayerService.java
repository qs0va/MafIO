package ru.iospb.mafia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.iospb.mafia.model.Player;
import ru.iospb.mafia.repos.PlayerGameRepository;
import ru.iospb.mafia.repos.PlayerRepository;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    PlayerGameRepository playerGameRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).get();
    }
    public void deletePlayerById(Long id) {
        playerRepository.deleteById(id);
    }
}
