package org.example.service;

import org.example.DAO.ComercioDAO;
import org.example.model.Comercio;

import java.util.List;

public class ComercioService {
    private ComercioDAO comercioDAO = new ComercioDAO();

    public void addComercio(Comercio comercio) {
        comercioDAO.create(comercio);
    }

    public Comercio getComercio(String CNPJ) {
        return comercioDAO.read(CNPJ);
    }

    public void updateComercio(Comercio comercio) {
        comercioDAO.update(comercio);
    }

    public void deleteComercio(String CNPJ) {
        comercioDAO.delete(CNPJ);
    }

    public List<Comercio> getAllComercios() {
        return comercioDAO.getAll();
    }
}
