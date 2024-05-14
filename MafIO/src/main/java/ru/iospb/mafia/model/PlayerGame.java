package ru.iospb.mafia.model;

import jakarta.persistence.*;

@Entity
public class PlayerGame {
    @EmbeddedId
    PlayerGameKey id = new PlayerGameKey();

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("playerId")
    @JoinColumn(name = "player_id")
    Player player;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("gameId")
    @JoinColumn(name = "game_id")
    Game game;

    double rating;

    public PlayerGameKey getId() {
        return id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
        this.id.playerId = player.id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
        this.id.gameId = game.id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
