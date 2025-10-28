package com.catappback.backend.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.catappback.backend.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Optional<Usuario> findByUsername(String username);
}