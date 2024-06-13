package com.makhdoom.BookYourShow.models;

import com.makhdoom.BookYourShow.enums.PaymentMethodType;
import com.makhdoom.BookYourShow.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {

    private String reference;
    private Double amount;

    @Enumerated
    private PaymentMethodType providerType;

    @Enumerated
    private PaymentStatus status;
}
