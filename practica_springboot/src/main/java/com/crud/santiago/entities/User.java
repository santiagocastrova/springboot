package com.crud.santiago.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Long id;
    @Column(name="name", length = 100, nullable = false, unique = false)
    String name;
    @Column(name="age", length = 100, nullable = false, unique = false)
    Integer age;
    @Column(name="email", length = 100, nullable = false, unique = false)
    String email;
    @Column(name="password", length = 100, nullable = false, unique = false)
    String password;
}
