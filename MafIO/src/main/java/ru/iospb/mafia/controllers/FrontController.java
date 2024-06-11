package ru.iospb.mafia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class FrontController {
    @GetMapping("/main")
    String mainPage() {
        return "index";
    }

    @GetMapping("/")
    RedirectView redirectToMainPage() {
        return new RedirectView("/main");
    }

    @GetMapping("/players")
    String playersPage() {
        return "players";
    }

    @GetMapping("/players/{id}")
    String onePlayerPage() {
        return "aplayer";
    }

    @GetMapping("/games")
    String gamesPage() {
        return "games";
    }

    @GetMapping("/games/{i}")
    String oneGamePage() {
        return "agame";
    }

    @GetMapping("/newGame")
    String newGamePage() {
        return "newgame";
    }

    @GetMapping("/rating")
    String ratingPage() {
        return "rating";
    }
}
