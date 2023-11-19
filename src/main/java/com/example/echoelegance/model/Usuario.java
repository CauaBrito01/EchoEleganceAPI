package com.example.echoelegance.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario {
    //serve para marcar como chave primaria
    @Id
    //serve para que o spring gerar o id automaticamente
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    private long idUsuario;  

    private String nomeUsuario;      

    private String emailUsuario;

    private String senhaUsuario;  

    private float cpf;

    private String endereco;  

    @OneToMany(mappedBy = "usuario")
    private List<AvaliacaoProduto> avaliacoes;


    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }


    public String getnomeUsuario() {
        return nomeUsuario;
    }

    public void setnomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }


    public String getemailUsuario() {
        return emailUsuario;
    }

    public void setemailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    
    public String getsenhaUsuario() {
        return senhaUsuario;
    }

    public void setsenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
        public float getcpf() {
        return cpf;
    }

    public void setcpf(float cpf) {
        this.cpf = cpf;
    }

}
