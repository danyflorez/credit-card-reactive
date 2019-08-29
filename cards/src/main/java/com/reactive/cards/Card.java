package com.reactive.cards;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@Builder
public class Card {

    @Id
    private String id;

    private String userId;

    private String type;

    private String cardId;

}
