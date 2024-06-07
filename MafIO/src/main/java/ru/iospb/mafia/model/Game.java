package ru.iospb.mafia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    boolean townWins;
    String tag;
    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY)
    List<Participation> participations = new ArrayList<>();


    public List<Participation> getParticipations() {
        return participations;
    }
    public Long getId() {
        return id;
    }
    public boolean isTownWins() {
        return townWins;
    }
    public void setTownWins(boolean townWins) {
        this.townWins = townWins;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", townWins=" + townWins +
                ", tag='" + tag + '\'' +
                '}';
    }
}
