package ru.iospb.mafia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String nickname;

    @JsonIgnore
    @OneToMany(mappedBy = "player", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    List<PlayerGame> playersGames = new ArrayList<>();

    public List<PlayerGame> getPlayersGames() {
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
