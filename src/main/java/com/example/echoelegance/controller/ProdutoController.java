package com.example.echoelegance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.echoelegance.model.Produto;
import com.example.echoelegance.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "http://localhost:4200") // Especifique a origem permitida
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public List<Produto> listar() {
        return repository.findAll();
    }

    @GetMapping("/{idProduto}")
    public Produto listarUm(@PathVariable Long idProduto) {
        return repository.findById(idProduto).orElse(null);
    }

    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    @PutMapping("/{idProduto}")
    public Produto editar(@PathVariable Long idProduto, @RequestBody Produto produto) {
    Long produtoId = produto.getIdProduto();
    if (produtoId != null && produtoId.equals(idProduto)) {
        return repository.save(produto);
    }
    return null;
}


    @DeleteMapping("/{idProduto}")
    public String deletar(@PathVariable Long idProduto) {
        if (idProduto != null) {
            repository.deleteById(idProduto);
            return "deletado";
        }
        return "ID do produto não encontrado";
    }

    // Lidar com solicitações OPTIONS
    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public void handleOptions() {
    // Adicione os cabeçalhos CORS necessários para as solicitações OPTIONS
    }
}
