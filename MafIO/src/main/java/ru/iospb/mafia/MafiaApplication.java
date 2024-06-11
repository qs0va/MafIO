package ru.iospb.mafia;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.iospb.mafia.model.Game;
import ru.iospb.mafia.model.Participation;
import ru.iospb.mafia.model.Player;
import ru.iospb.mafia.rating.Row;
import ru.iospb.mafia.repos.GameRepository;
import ru.iospb.mafia.repos.ParticipationRepository;
import ru.iospb.mafia.repos.PlayerRepository;
import ru.iospb.mafia.repos.RatingRepository;


@SpringBootApplication
public class MafiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MafiaApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(GameRepository gameRepository,
							 PlayerRepository playerRepository,
							 ParticipationRepository participationRepository,
							 RatingRepository ratingRepository) {
		return args -> {
			System.out.println("Hello from command line runner");

			// Building test entities
			Player bob1 = new Player();
			bob1.setNickname("bob1");
			Player bob2 = new Player();
			bob2.setNickname("bob2");
			Player bob3 = new Player();
			bob3.setNickname("bob3");
			Player bob4 = new Player();
			bob4.setNickname("bob4");
			Player bob5 = new Player();
			bob5.setNickname("bob5");
			Player bob6 = new Player();
			bob6.setNickname("bob6");
			Player bob7 = new Player();
			bob7.setNickname("bob7");
			Player bob8 = new Player();
			bob8.setNickname("bob8");
			Player bob9 = new Player();
			bob9.setNickname("bob9");
			Player bob10 = new Player();
			bob10.setNickname("bob10");

			Game g1 = new Game();
			g1.setTag("1");
			g1.setTownWins(true);

			Game g2 = new Game();
			g2.setTag("2");
			g1.setTownWins(false);

			// Saving
			playerRepository.save(bob1);
			playerRepository.save(bob2);
			playerRepository.save(bob3);
			playerRepository.save(bob4);
			playerRepository.save(bob5);
			playerRepository.save(bob6);
			playerRepository.save(bob7);
			playerRepository.save(bob8);
			playerRepository.save(bob9);
			playerRepository.save(bob10);

			gameRepository.save(g1);
			gameRepository.save(g2);

			// Setting relations
			for (int i = 0; i < 10; i++) {
				Participation temp = new Participation();
				temp.setGame(g1);
				switch (i + 1) {
					case 1:
						temp.setPlayer(bob1);
						break;
					case 2:
						temp.setPlayer(bob2);
						break;
					case 3:
						temp.setPlayer(bob3);
						break;
					case 4:
						temp.setPlayer(bob4);
						break;
					case 5:
						temp.setPlayer(null);
						break;
					case 6:
						temp.setPlayer(bob6);
						break;
					case 7:
						temp.setPlayer(bob7);
						break;
					case 8:
						temp.setPlayer(null);
						break;
					case 9:
						temp.setPlayer(bob9);
						break;
					case 10:
						temp.setPlayer(bob10);
						break;
				}
				temp.setRating(0);
				temp.setRole("");
				temp.setSlot(i + 1);
				if (i != 2 && i != 3) {
					participationRepository.save(temp);
				}
			}
		};
	}
}
