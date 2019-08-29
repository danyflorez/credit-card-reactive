package com.reactive.cards;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

	@Bean
	CommandLineRunner init(CardRepository cardRepository){

		Card card1 = Card.builder().cardId("1").userId("1").type("VISA").build();
		Card card2 = Card.builder().cardId("2").userId("1").type("VISA").build();

		return (args) ->{
			cardRepository
					.deleteAll()
					.thenMany(
						Flux.just(card1, card2)
								.flatMap(cardRepository::save)

					)
					.thenMany(cardRepository.findAll())
					.subscribe();
		};

	}




}
