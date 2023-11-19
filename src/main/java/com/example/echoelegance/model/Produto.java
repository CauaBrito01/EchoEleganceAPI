package com.example.echoelegance.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Produto {
    
    //serve para marcar como chave primaria
    @Id
    //serve para que o spring gerar o id automaticamente
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    private long idProduto;  

    private int preco;      

    private String tituloProduto;  

    private String dscProduto;  

    private String marca;  

    private boolean indAtivo;  

    private int idAnunciante;  

    private int qtdProduto;  

    private int avgNota;  
    
    private String imgProduto; 

    @OneToMany(mappedBy = "produto")
    private List<AvaliacaoProduto> avaliacoes;


    public String getimgProduto() {
        return imgProduto;
    }

    public void setimgProduto(String imgProduto) {
        this.imgProduto = imgProduto;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public String getTituloProduto() {
        return tituloProduto;
    }

    public void setTituloProduto(String tituloProduto) {
        this.tituloProduto = tituloProduto;
    }

    public String getdscProduto() {
        return dscProduto;
    }

    public void setdscProduto(String dscProduto) {
        this.dscProduto = dscProduto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isindAtivo() {
        return indAtivo;
    }

    public void setindAtivo(boolean indAtivo) {
        this.indAtivo = indAtivo;
    }

    public int getIdAnunciante() {
        return idAnunciante;
    }

    public void setIdAnunciante(int idAnunciante) {
        this.idAnunciante = idAnunciante;
    }

    public int getqtdProduto() {
        return qtdProduto;
    }

    public void setqtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public int getavgNota() {
        return avgNota;
    }

    public void setavgNota(int avgNota) {
        this.avgNota = avgNota;
    }

}
