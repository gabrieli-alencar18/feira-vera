package org.example.model;

public class Comercio {
    private String CNPJ;
    private String nomeDaEmpresa;
    private String enderecoBarraca;
    private String enderecoAtualEmpresa;

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getNomeDaEmpresa() {
        return nomeDaEmpresa;
    }

    public void setNomeDaEmpresa(String nomeDaEmpresa) {
        this.nomeDaEmpresa = nomeDaEmpresa;
    }

    public String getEnderecoBarraca() {
        return enderecoBarraca;
    }

    public void setEnderecoBarraca(String enderecoBarraca) {
        this.enderecoBarraca = enderecoBarraca;
    }

    public String getEnderecoAtualEmpresa() {
        return enderecoAtualEmpresa;
    }

    public void setEnderecoAtualEmpresa(String enderecoAtualEmpresa) {
        this.enderecoAtualEmpresa = enderecoAtualEmpresa;
    }
}

