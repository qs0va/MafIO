package ru.iospb.mafia.rating;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;

class RoleCount {
    Long T;
    Long M;
    Long Sh;
    Long D;

    public RoleCount(Long d, Long sh, Long m, Long t) {
        D = d;
        Sh = sh;
        M = m;
        T = t;
    }
}

class RoleRating {
    Long T;
    Long M;
    Long Sh;
    Long D;

    public RoleRating(Long d, Long sh, Long m, Long t) {
        D = d;
        Sh = sh;
        M = m;
        T = t;
    }
}

public class Row {
    String nickname;

    RoleCount gamesCount;

    RoleCount winsCount;

    RoleRating ratings;

    Long LH;

    Long LHlost;

    public Row(
            String nickname,
            long TCount,
            long MCount,
            long SCount,
            long DCount,
            long TWins,
            long MWins,
            long SWins,
            long DWins,
            double TRating,
            double MRating,
            double SRating,
            double DRating,
            long LH,
            long LHlost
            ) {
        this.nickname = nickname;
        this.gamesCount = new RoleCount(DCount, SCount, MCount, TCount);
        this.winsCount = new RoleCount(DWins, SWins, MWins, TWins);
        this.LH = LH;
        this.LHlost = LHlost;
    }
}
