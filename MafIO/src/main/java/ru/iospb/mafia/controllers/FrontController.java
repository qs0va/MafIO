package ru.iospb.mafia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class FrontController {
    @GetMapping("/main")
    String mainPage() {
        return "index.html";
    }

    @GetMapping("/")
    RedirectView redirectToMainPage() {
        return new RedirectView("/main");
    }

    @GetMapping("/players")
    String playersPage() {
        return "players.html";
    }

    @GetMapping("/games")
    String gamesPage() {
        return "games.html";
    }

    @GetMapping("/rating")
    String ratingPage() {
        return "rating.html";
    }

    @GetMapping("/newGame")
    String newGamePage() {
        return "rating.html";
    }
}
