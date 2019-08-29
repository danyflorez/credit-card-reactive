package com.reactive.cards;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface CardRepository extends ReactiveMongoRepository<Card, String> {

    Flux<Card> findByUserId(String userId);
}
