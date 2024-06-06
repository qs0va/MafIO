package ru.iospb.mafia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.iospb.mafia.model.Game;
import ru.iospb.mafia.model.Participation;
import ru.iospb.mafia.model.Player;
import ru.iospb.mafia.repos.GameRepository;
import ru.iospb.mafia.repos.ParticipationRepository;
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
    ParticipationRepository playerGameRepository;

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game getGameById(Long id) {
        Game out = gameRepository.findById(id).get();

        Player guest = new Player();
        guest.setNickname("Гость");

        Participation blank = new Participation();
        blank.setRole("-");
        blank.setRating(0);
        blank.setSlot(0);
        blank.setPlayer(guest);

        int i = 0;
        for (Participation pg : out.getParticipations()) {
            if (Objects.isNull(pg.getPlayer())) {
                pg.setPlayer(guest);
            }
            i++;
        }
        for (;i < 10; i++) {
            out.getParticipations().add(blank);
        }

        Collections.sort(out.getParticipations());

        return out;
    }

    public void addNewGame(List<Participation> participationList) {
        Game game = new Game();
        game.setNumber("11");
        gameRepository.save(game);
        for (var pg : participationList) {
            pg.setGame(game);
            var id = pg.getPlayer().getId();
            pg.setPlayer(playerRepository.findById(id).get());
            playerGameRepository.save(pg);
        }
    }
}
