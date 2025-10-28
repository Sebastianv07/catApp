package com.catappback.backend;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.catappback.backend.model.Usuario;
import com.catappback.backend.repository.UsuarioRepository;
import com.catappback.backend.service.UsuarioService;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock 
    private UsuarioRepository repo;

    @InjectMocks 
    private UsuarioService service;

    @Test
    public void registerAndLogin() {
        when(repo.findByUsername("u")).thenReturn(Optional.empty());

        Usuario saved = new Usuario();
        saved.setId("1");
        saved.setUsername("u");
        saved.setPassword(new BCryptPasswordEncoder().encode("pass"));

        when(repo.save(any())).thenReturn(saved);

        Usuario nuevo = new Usuario();
        nuevo.setUsername("u");
        nuevo.setEmail("e@e");
        nuevo.setPassword("pass");

        Usuario registrado = service.register(nuevo);
        assertNotNull(registrado);

        when(repo.findByUsername("u")).thenReturn(Optional.of(saved));
        Optional<Usuario> login = service.login("u", "pass");
        assertTrue(login.isPresent());
    }
}
