package ru.iospb.mafia.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.iospb.mafia.model.Player;

import java.util.List;

@RestController
public class PlayersController {
    @GetMapping("/data/players")
    List<Player> allPlayers() {
        return 
    }
}
