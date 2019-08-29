package com.reactive.payment;

import lombok.Data;

@Data
public class PaymentDTO {

    private String userId;
    private String cardId;
    private double amount;
}
