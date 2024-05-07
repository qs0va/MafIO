package ru.iospb.mafia.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.iospb.mafia.model.Game;
import ru.iospb.mafia.model.Player;
import ru.iospb.mafia.repos.GameRepository;
import ru.iospb.mafia.repos.PlayerRepository;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "ru.iospb.mafia")
@EntityScan("ru.iospb.mafia")
public class MafiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MafiaApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(GameRepository gameRepository, PlayerRepository playerRepository) {
		return args -> {
			System.out.println("Hello from command line runner");

			// Building test entities
			Player bob1 = new Player();
			bob1.setNickname("bob");
			Player bob2 = new Player();
			bob2.setNickname("bob");
			Player bob3 = new Player();
			bob3.setNickname("bob");
			Player bob4 = new Player();
			bob4.setNickname("bob");
			Player bob5 = new Player();
			bob5.setNickname("bob");
			Player bob6 = new Player();
			bob6.setNickname("bob");
			Player bob7 = new Player();
			bob7.setNickname("bob");
			Player bob8 = new Player();
			bob8.setNickname("bob");
			Player bob9 = new Player();
			bob9.setNickname("bob");
			Player bob10 = new Player();
			bob10.setNickname("bob");

			Game g1 = new Game();
			g1.setNumber("1");
			Game g2 = new Game();
			g2.setNumber("2");

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

			// Loading
			System.out.println(playerRepository.findAll());
			System.out.println(gameRepository.findAll());
		};
	}
}
