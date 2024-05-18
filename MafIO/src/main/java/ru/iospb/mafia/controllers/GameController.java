package ru.iospb.mafia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.iospb.mafia.model.Game;
import ru.iospb.mafia.model.PlayerGame;
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

    @GetMapping("/data/games/{id}")
    Game aGame(@PathVariable Long id) {
        return gameService.getGameById(id);
    }

    @PutMapping("/data/games")
    void newGame(@RequestBody List<PlayerGame> body) {
        gameService.addNewGame(body);
    }
}
