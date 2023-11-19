package com.example.echoelegance.controller;


import java.util.List; // Importe List do pacote java.util

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.echoelegance.model.Anunciante;
import com.example.echoelegance.repository.AnuncianteRepository;



@RestController
@RequestMapping("/anunciante")
public class AnuncianteController {
    

    @Autowired
    //liga o repository a controller
    private AnuncianteRepository repository;


    //usa o findAll para pegar tudo que tem e retorna ele
    @GetMapping
    public List<Anunciante> listar (){
        return repository.findAll();
    }

    //envia e ria o objeto json de Anunciante
    @PostMapping
    public Anunciante criar (@RequestBody Anunciante Anunciante){
        return repository.save(Anunciante);
    }

    @PutMapping
    public Anunciante editar(@RequestBody Anunciante Anunciante){
        if(Anunciante.getIdAnunciante() > 0) {
            return repository.save(Anunciante);
        }
        return null;
    }

    @DeleteMapping
    public String deletar(@RequestBody Anunciante Anunciante){
        if (Anunciante.getIdAnunciante() > 0){
            repository.delete(Anunciante);
            return "deeletado";
        }
        return "usuario não encontrado";
    }

}

