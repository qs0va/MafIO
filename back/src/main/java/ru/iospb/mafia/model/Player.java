package ru.iospb.mafia.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String nickname;

    @OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
    Set<PlayerGame> playersGames = new HashSet<>();

    public Set<PlayerGame> getPlayersGames() {
        return playersGames;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
