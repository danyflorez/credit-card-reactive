package com.reactive.cards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(path = "/cards")
public class CardController {

    @Autowired
    CardRepository cardRepository;

    @GetMapping(path = "/user/{userId}")
    public Flux<Card> findByUser(@PathVariable("userId") String userId){
        return cardRepository.findByUserId(userId);
    }

    @GetMapping
    public Flux<Card> findAll(){
        return cardRepository.findAll();
    }
}
