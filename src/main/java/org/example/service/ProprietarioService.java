package org.example.service;

import org.example.DAO.ProprietarioDAO;
import org.example.model.Proprietario;

import java.util.List;

public class ProprietarioService {
    private ProprietarioDAO proprietarioDAO = new ProprietarioDAO();

    public void addProprietario(Proprietario proprietario) {
        proprietarioDAO.create(proprietario);
    }

    public Proprietario getProprietario(String CPF) {
        return proprietarioDAO.read(CPF);
    }

    public void updateProprietario(Proprietario proprietario) {
        proprietarioDAO.update(proprietario);
    }

    public void deleteProprietario(String CPF) {
        proprietarioDAO.delete(CPF);
    }

    public List<Proprietario> getAllProprietarios() {
        return proprietarioDAO.getAll();
    }
}
