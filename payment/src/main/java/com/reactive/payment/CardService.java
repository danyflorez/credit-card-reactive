package com.reactive.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class CardService {

    @Autowired
    PaymentRepository paymentRepository;

    public Mono<Payment> payment(PaymentDTO payment){
        return WebClient.create("http://localhost:8080")
                .get()
                .uri(i -> i.path("/cards/users/{userId}")
                        .build(payment.getUserId())
                ).retrieve()
                .bodyToFlux(CardDTO.class)
                .filter(i -> payment.getCardId().equals(i.getCardId()))
                .collectList()
                .flatMap(i -> {
                    if(i.isEmpty()){
                        return Mono.error(new RuntimeException(String.format("User doesn't have the card %s", payment.getCardId())));
                    } else {
                        Payment p = Payment.builder()
                                .amount(payment.getAmount())
                                .cardId(payment.getCardId())
                                .userId(payment.getUserId())
                                .cardType(i.get(0).getType())
                                .build();
                        System.out.printf("INSERTING A PAYMENT %s", payment);
                        return paymentRepository.insert(p);
                    }
                });
    }
}
