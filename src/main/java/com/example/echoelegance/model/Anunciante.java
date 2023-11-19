package com.example.echoelegance.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Anunciante {
    //serve para marcar como chave primaria
    @Id
    //serve para que o spring gerar o id automaticamente
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    private long idAnunciante;  

    private String nomeAnunciante;      

    private Date dataCadastro;  

    private float AVG_RATING;  

    private String endereco;  

    private float cnpj;  

    private String emailAnunciante;

    public long getIdAnunciante() {
        return idAnunciante;
    }

    public void setIdAnunciante(long idAnunciante) {
        this.idAnunciante = idAnunciante;
    }


    public String getnomeAnunciante() {
        return nomeAnunciante;
    }

    public void setnomeAnunciante(String nomeAnunciante) {
        this.nomeAnunciante = nomeAnunciante;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

        public float getAVG_RATING() {
        return AVG_RATING;
    }

    public void setAVG_RATING(float AVG_RATING) {
        this.AVG_RATING = AVG_RATING;
    }


        public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
        public float getCnpj() {
        return cnpj;
    }

    public void setCnpj(float cnpj) {
        this.cnpj = cnpj;
    }

       public String getemailAnunciante() {
        return emailAnunciante;
    }

    public void setemailAnunciante(String emailAnunciante) {
        this.emailAnunciante = emailAnunciante;
    }
}
