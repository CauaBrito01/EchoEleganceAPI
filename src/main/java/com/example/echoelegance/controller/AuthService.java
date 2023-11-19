package com.example.echoelegance.controller;

public interface AuthService {
    Object authenticate(String emailUsuario, String senhaUsuario, int IdUsuario);
}

