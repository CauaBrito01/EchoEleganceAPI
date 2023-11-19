package com.example.echoelegance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.echoelegance.model.Usuario;
import com.example.echoelegance.repository.UsuarioRepository;
import com.example.echoelegance.model.LoginRequest;


@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {
    
    @Autowired
    private AuthService authService;

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public List<Usuario> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    @PutMapping
    public Usuario editar(@RequestBody Usuario usuario) {
        if (usuario.getIdUsuario() > 0) {
            return repository.save(usuario);
        }
        return null;
    }

    @DeleteMapping
    public String deletar(@RequestBody Usuario usuario) {
        if (usuario.getIdUsuario() > 0) {
            repository.delete(usuario);
            return "Deletado";
        }
        return "Usuário não encontrado";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        System.out.println("Recebido pedido de login: " + loginRequest.toString());
        String redirectToPage = authService.authenticate(loginRequest.getEmailUsuario(), loginRequest.getSenhaUsuario());

        if (redirectToPage != null) {
            // Redirecionamento bem-sucedido
            return ResponseEntity.ok().body(redirectToPage);
        } else {
            // Autenticação falhou
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
    }
}
