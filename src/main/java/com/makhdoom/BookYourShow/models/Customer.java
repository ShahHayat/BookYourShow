package com.makhdoom.BookYourShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Customer extends BaseModel {

    private String fullName;
    private String city;
    private String phoneNumber;
    private String email;

    @OneToOne
    private User user;
}
