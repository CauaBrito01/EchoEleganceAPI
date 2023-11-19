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

import com.example.echoelegance.model.AvaliacaoProduto;
import com.example.echoelegance.repository.AvaliacaoProdutoRepository;



@RestController
@RequestMapping("/avaliacao-produto")
public class AvaliacaoProdutoController {
    

    @Autowired
    //liga o repository a controller
    private AvaliacaoProdutoRepository repository;


    //usa o findAll para pegar tudo que tem e retorna ele
    @GetMapping
    public List<AvaliacaoProduto> listar (){
        return repository.findAll();
    }

    //envia e ria o objeto json de AvaliacaoProduto
    @PostMapping
    public AvaliacaoProduto criar (@RequestBody AvaliacaoProduto AvaliacaoProduto){
        return repository.save(AvaliacaoProduto);
    }

    @PutMapping
    public AvaliacaoProduto editar(@RequestBody AvaliacaoProduto AvaliacaoProduto){
        if(AvaliacaoProduto.getidAvaliacao() > 0) {
            return repository.save(AvaliacaoProduto);
        }
        return null;
    }

    @DeleteMapping
    public String deletar(@RequestBody AvaliacaoProduto AvaliacaoProduto){
        if (AvaliacaoProduto.getidAvaliacao() > 0){
            repository.delete(AvaliacaoProduto);
            return "deeletado";
        }
        return "avaliacao não encontrada";
    }

}

