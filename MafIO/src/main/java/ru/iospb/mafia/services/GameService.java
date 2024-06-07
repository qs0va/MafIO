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
        blank.setRating(0);
        blank.setSlot(0);
        blank.setPlayer(guest);

        int i = 0;
        for (Participation participation : out.getParticipations()) {
            if (Objects.isNull(participation.getPlayer())) {
                participation.setPlayer(guest);
            }
            i++;
        }
        for (;i < 10; i++) {
            out.getParticipations().add(blank);
        }

        Collections.sort(out.getParticipations());

        return out;
    }

    public void addNewGame(List<Participation> participationList, boolean townWins, String tag) {
        Game game = new Game();
        game.setTag(tag);
        game.setTownWins(townWins);
        gameRepository.save(game);
        for (var participation : participationList) {
            var id = participation.getPlayer().getId();
            if (id != 0) {
                participation.setPlayer(playerRepository.findById(id).get());
            }
            else {
                participation.setPlayer(null);
            }
            participation.setGame(game);
            playerGameRepository.save(participation);
        }
    }
}
