package ru.iospb.mafia.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.iospb.mafia.model.Game;
import ru.iospb.mafia.model.Participation;
import ru.iospb.mafia.services.GameService;

import java.util.List;

@RestController
public class GameController {
    @Autowired
    GameService gameService;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/data/games")
    List<Game> allGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/data/games/{id}")
    Game aGame(@PathVariable Long id) {
        return gameService.getGameById(id);
    }

    @PostMapping("/data/games")
    void newGame(@RequestParam String participations, @RequestParam boolean townWins, @RequestParam String tag) throws JsonProcessingException {
        List<Participation> plist = objectMapper.readValue(participations, objectMapper.getTypeFactory().constructCollectionType(List.class, Participation.class));
        System.out.println(plist);
        gameService.addNewGame(plist, townWins, tag);
    }
}
