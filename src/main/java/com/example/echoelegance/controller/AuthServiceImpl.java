package com.example.echoelegance.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.echoelegance.repository.UsuarioRepository;

import com.example.echoelegance.model.Usuario;


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
public String authenticate(String emailUsuario, String senhaUsuario) {
        System.out.println("Autenticando usuário: " + emailUsuario + "senha"+ senhaUsuario);
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmailUsuarioAndSenhaUsuario(emailUsuario, senhaUsuario);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            // Autenticação bem-sucedida, retorne a página de home (ou o que for apropriado)

            System.out.println("ai calica");

            return "/home";
            
        } else {
            // Autenticação falhou
            System.err.println("eita");
            return null;
        }
    }
}


