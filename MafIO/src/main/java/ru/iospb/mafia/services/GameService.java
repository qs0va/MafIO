package ru.iospb.mafia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.iospb.mafia.model.Game;
import ru.iospb.mafia.model.Player;
import ru.iospb.mafia.model.PlayerGame;
import ru.iospb.mafia.repos.GameRepository;
import ru.iospb.mafia.repos.PlayerGameRepository;
import ru.iospb.mafia.repos.PlayerRepository;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    PlayerGameRepository playerGameRepository;

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game getGameById(Long id) {
        Game out = gameRepository.findById(id).get();

        Player guest = new Player();
        guest.setNickname("Гость");

        PlayerGame blank = new PlayerGame();
        blank.setRole("-");
        blank.setRating(0);
        blank.setSlot(0);
        blank.setPlayer(guest);

        int i = 0;
        for (PlayerGame pg : out.getPlayersGames()) {
            if (Objects.isNull(pg.getPlayer())) {
                pg.setPlayer(guest);
            }
            i++;
        }
        for (;i < 10; i++) {
            out.getPlayersGames().add(blank);
        }

        Collections.sort(out.getPlayersGames());

        return out;
    }

    public void addNewGame(List<PlayerGame> playerGameList) {
        Game game = new Game();
        game.setNumber("11");
        gameRepository.save(game);
        for (var pg : playerGameList) {
            pg.setGame(game);
            var id = pg.getPlayer().getId();
            pg.setPlayer(playerRepository.findById(id).get());
            playerGameRepository.save(pg);
        }
    }
}
