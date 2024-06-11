package ru.iospb.mafia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import ru.iospb.mafia.rating.Row;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@SqlResultSetMapping (
        name="RowRatingMapping",
        classes = @ConstructorResult(
                targetClass = Row.class,
                columns = {
                        @ColumnResult(name = "nickname"),
                        @ColumnResult(name = "Tcount"),
                        @ColumnResult(name = "Mcount"),
                        @ColumnResult(name = "Scount"),
                        @ColumnResult(name = "Dcount"),
                        @ColumnResult(name = "Twins"),
                        @ColumnResult(name = "Mwins"),
                        @ColumnResult(name = "Swins"),
                        @ColumnResult(name = "Dwins"),
                        @ColumnResult(name = "Twins"),
                        @ColumnResult(name = "Mwins"),
                        @ColumnResult(name = "Swins"),
                        @ColumnResult(name = "Dwins"),
                        @ColumnResult(name = "lh"),
                        @ColumnResult(name = "lh_lost"),
                }
        )
)
@NamedNativeQuery(name="Player.ft", query = "SELECT p.nickname, COUNT(*) count FROM player p WHERE p.id = 1", resultSetMapping = "RowRatingMapping")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String nickname;
    String password;
    String role;

    @JsonIgnore
    @OneToMany(mappedBy = "player", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    List<Participation> participations = new ArrayList<>();

    public Player() {
        role = "ROLE_PLAYER";
    }

    public List<Participation> getParticipations() {
        return participations;
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
