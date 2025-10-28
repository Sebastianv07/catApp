package com.catappback.backend.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.catappback.backend.repository.UsuarioRepository;
import com.catappback.backend.model.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public Usuario register(Usuario user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return usuarioRepository.save(user);
    }

    public Optional<Usuario> login(String username, String password) {
        Optional<Usuario> user = usuarioRepository.findByUsername(username);
        if (user.isPresent() && encoder.matches(password, user.get().getPassword())) {
            return user;
        }
        return Optional.empty();
    }

    public Usuario register(String string, String string2, String string3) {
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }
}
