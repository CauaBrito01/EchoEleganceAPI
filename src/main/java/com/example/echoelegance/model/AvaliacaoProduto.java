package com.example.echoelegance.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AvaliacaoProduto {
    //serve para marcar como chave primaria
    @Id
    //serve para que o spring gerar o id automaticamente
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    private long idAvaliacao;  

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto; 

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;  

    private String DescAvaliacao;

    private float NotaAvaliacao;



    
    public long getidAvaliacao() {
        return idAvaliacao;
    }

    public void setidAvaliacao(long idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getDescAvaliacao() {
        return DescAvaliacao;
    }

    public void setDescAvaliacao(String descAvaliacao) {
        DescAvaliacao = descAvaliacao;
    }

    public float getNotaAvaliacao() {
        return NotaAvaliacao;
    }

    public void setNotaAvaliacao(float notaAvaliacao) {
        NotaAvaliacao = notaAvaliacao;
    }

}
