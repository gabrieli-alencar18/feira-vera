package org.example.model;

public class Proprietario {
    private String CPF;
    private String nome;
    private String endereco;
    private String CNPJComercio;

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCNPJComercio() {
        return CNPJComercio;
    }

    public void setCNPJComercio(String CNPJComercio) {
        this.CNPJComercio = CNPJComercio;
    }
}
