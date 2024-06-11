package ru.iospb.mafia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.iospb.mafia.rating.Row;
import ru.iospb.mafia.repos.RatingRepository;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    RatingRepository ratingRepository;

    public List<Row> getRating(String sortingParameter, Long minimumGames) {
        return null;
    }
}
