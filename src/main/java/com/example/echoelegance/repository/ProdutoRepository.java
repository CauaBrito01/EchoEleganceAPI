package com.example.echoelegance.repository;

//onde nois faz a ligação com o B

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.echoelegance.model.Produto;

//referencia o nome da tabela e a chave primeria da classe
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
}
