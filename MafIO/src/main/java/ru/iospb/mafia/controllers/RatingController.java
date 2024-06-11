package ru.iospb.mafia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.iospb.mafia.rating.Row;
import ru.iospb.mafia.services.RatingService;

import java.util.List;

@RestController
public class RatingController {
    @Autowired
    RatingService ratingService;

    @GetMapping("/data/rating")
    List<Row> getRating(String sortingParameter, Long minimumGames) {
        return ratingService.getRating(sortingParameter, minimumGames);
    }
}
