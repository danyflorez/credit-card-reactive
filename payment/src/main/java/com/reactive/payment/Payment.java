package com.reactive.payment;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@Builder
public class Payment {

    @Id
    private String id;

    private double amount;

    private String userId;

    private String cardId;

    private String cardType;
}
