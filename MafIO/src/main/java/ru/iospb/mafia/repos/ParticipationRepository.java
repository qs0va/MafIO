package ru.iospb.mafia.repos;

import org.springframework.data.repository.CrudRepository;
import ru.iospb.mafia.model.Participation;

public interface ParticipationRepository extends CrudRepository<Participation, Long> {

    void deleteAllByPlayerId(Long id);
}
