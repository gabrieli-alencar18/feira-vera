package org.example.model;

import java.sql.Date;

public class Venda {
    private int idVenda;
    private String CNPJComercio;
    private double valorVenda;
    private Date dataVenda;

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getCNPJComercio() {
        return CNPJComercio;
    }

    public void setCNPJComercio(String CNPJComercio) {
        this.CNPJComercio = CNPJComercio;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }
}

