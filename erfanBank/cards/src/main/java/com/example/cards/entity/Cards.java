package com.example.cards.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Cards extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "navtive")
    @GenericGenerator(name = "native" , strategy = "native")
    private Long cardId;

    private String mobileNumber;

    private String cardNumber;

    private String cardType;

    private Integer totalLimit;

    private Integer amountUsed;

    private Integer availableAmount;
}
