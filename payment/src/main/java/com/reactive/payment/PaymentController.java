package com.reactive.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    CardService cardService;

    @Autowired
    PaymentRepository paymentRepository;

    @PostMapping
    public Mono<Payment> payment(@RequestBody PaymentDTO paymentDTO){
        return cardService.payment(paymentDTO);
    }

    @GetMapping
    public Flux<Payment> get(){
        return paymentRepository.findAll();
    }

}
