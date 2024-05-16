package ru.iospb.mafia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String number;

    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY)
    Set<PlayerGame> playersGames = new HashSet<>();

    public Set<PlayerGame> getPlayersGames() {
        return playersGames;
    }

    boolean townWins;

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isTownWins() {
        return townWins;
    }

    public void setTownWins(boolean townWins) {
        this.townWins = townWins;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
