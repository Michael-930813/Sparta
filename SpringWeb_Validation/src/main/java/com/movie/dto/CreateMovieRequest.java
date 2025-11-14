package com.movie.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class CreateMovieRequest {

    @NotBlank
    private String title;
    @Email
    private String email;
    @Size(min=4, max=16)
    private String password;
    @Pattern(regexp = "^010-\\d{4}-\\d{4}$")
    private String phoneNumber;
}
