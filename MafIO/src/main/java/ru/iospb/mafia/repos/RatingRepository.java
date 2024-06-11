package ru.iospb.mafia.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.iospb.mafia.model.Player;
import ru.iospb.mafia.rating.Row;

import java.util.List;

public interface RatingRepository extends JpaRepository<Player, Long> {
    @Query(nativeQuery = true)
    Row ft();
}
