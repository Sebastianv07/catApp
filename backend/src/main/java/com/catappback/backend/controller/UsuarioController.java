package com.catappback.backend.controller;

import java.util.*;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.catappback.backend.model.Usuario;
import com.catappback.backend.service.UsuarioService;
import lombok.*;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping("/register")
    public Usuario register(@RequestBody Usuario user) {
        return usuarioService.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        Optional<Usuario> user = usuarioService.login(credentials.get("username"), credentials.get("password"));
        return user.isPresent() ?
                ResponseEntity.ok(user.get()) :
                ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
    }
}
