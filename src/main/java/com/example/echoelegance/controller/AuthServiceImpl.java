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
    public authResult authenticate(String emailUsuario, String senhaUsuario, int IdUsuario) {
        System.out.println("Autenticando usuário: " + emailUsuario + " senha: " + senhaUsuario);
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmailUsuarioAndSenhaUsuarioAndIdUsuario(emailUsuario, senhaUsuario, IdUsuario);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            // Autenticação bem-sucedida, retorne a página de home (ou o que for apropriado)
            System.out.println("Autenticação bem-sucedida");
            // Criar uma instância da classe AuthResult para conter ambos os valores
            AuthResult authResult = new AuthResult("/home", IdUsuario);
            return authResult;
        } else {
            // Autenticação falhou
            System.err.println("Autenticação falhou");
            return null;
        }
    }
}

 public static class AuthResult {
        private String returnUrl;
        private int userId;

        public AuthResult(String returnUrl, int userId) {
            this.returnUrl = returnUrl;
            this.userId = userId;
        }

        public String getReturnUrl() {
            return returnUrl;
        }

        public int getUserId() {
            return userId;
        }
    }
}
