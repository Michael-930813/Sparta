package org.example.springweb_restapi.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    // - Property
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    private String address;

    // - Constructor
    public User(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    // - Update
    public void update(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }
}
