package com.reactive.payment;

import lombok.Data;

@Data
public class CardDTO {

    private String userId;

    private String type;

    private String cardId;
}
