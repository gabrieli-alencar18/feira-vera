package org.example.service;

import org.example.DAO.SorteioDAO;
import org.example.model.Sorteio;

import java.util.List;

public class SorteioService {
    private SorteioDAO sorteioDAO = new SorteioDAO();

    public void addSorteio(Sorteio sorteio) {
        sorteioDAO.create(sorteio);
    }

    public Sorteio getSorteio(int idSorteio) {
        return sorteioDAO.read(idSorteio);
    }

    public void updateSorteio(Sorteio sorteio) {
        sorteioDAO.update(sorteio);
    }

    public void deleteSorteio(int idSorteio) {
        sorteioDAO.delete(idSorteio);
    }

    public List<Sorteio> getAllSorteios() {
        return sorteioDAO.getAll();
    }
}
