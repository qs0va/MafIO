package ru.iospb.mafia.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String number;

    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
    Set<PlayerGame> playersGames = new HashSet<>();

    public Set<PlayerGame> getPlayersGames() {
        return playersGames;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
