package com.catappback.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "usuarios")
public class Usuario {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
}