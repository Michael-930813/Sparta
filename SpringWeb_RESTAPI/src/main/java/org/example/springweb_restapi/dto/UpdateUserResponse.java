package org.example.springweb_restapi.dto;

import lombok.Getter;

@Getter
public class UpdateUserResponse {
    private final Long id;
    private final String name;
    private final String email;
    private final String address;

    public UpdateUserResponse(Long id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }
}
