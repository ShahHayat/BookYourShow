package com.makhdoom.BookYourShow.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateCustomerRequestDTO {

    private String fullName;
    private String city;
    private String phoneNumber;
    private String email;
    private String username;
    private String password;
}
