package ru.iospb.mafia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.iospb.mafia.model.Game;
import ru.iospb.mafia.services.GameService;

import java.util.List;

@RestController
public class GameController {
    @Autowired
    GameService gameService;

    @GetMapping("/data/games")
    List<Game> allGames() {
        return gameService.getAllGames();
    }

}
