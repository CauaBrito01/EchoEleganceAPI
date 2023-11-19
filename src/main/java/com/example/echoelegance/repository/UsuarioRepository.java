package com.example.echoelegance.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.echoelegance.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmailUsuarioAndSenhaUsuario(String emailUsuario, String senhaUsuario);
}