package org.example.springweb_restapi.dto;

import lombok.Getter;

@Getter
public class CreateUserRequest {
    private String name;
    private String email;
    private String address;
}
