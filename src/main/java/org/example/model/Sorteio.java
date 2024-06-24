package org.example.model;

import java.sql.Date;

public class Sorteio {
    private int idSorteio;
    private Date dataSorteio;
    private String CNPJGanhador;

    public int getIdSorteio() {
        return idSorteio;
    }

    public void setIdSorteio(int idSorteio) {
        this.idSorteio = idSorteio;
    }

    public Date getDataSorteio() {
        return dataSorteio;
    }

    public void setDataSorteio(Date dataSorteio) {
        this.dataSorteio = dataSorteio;
    }

    public String getCNPJGanhador() {
        return CNPJGanhador;
    }

    public void setCNPJGanhador(String CNPJGanhador) {
        this.CNPJGanhador = CNPJGanhador;
    }
}

