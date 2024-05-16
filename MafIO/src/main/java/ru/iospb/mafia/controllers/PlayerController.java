package ru.iospb.mafia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.iospb.mafia.model.Player;
import ru.iospb.mafia.services.PlayerService;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/data/players")
    List<Player> allPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/data/players/{id}")
    Player aPlayer(@PathVariable Long id) {
        return playerService.getPlayerById(id);
    }

    @DeleteMapping("/data/players/{id}")
    void deletePlayer(@PathVariable Long id) {
        playerService.deletePlayerById(id);
    }
}
