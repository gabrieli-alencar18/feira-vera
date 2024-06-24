package org.example.service;

import org.example.DAO.VendaDAO;
import org.example.model.Venda;

import java.util.List;

public class VendasService {
    private VendaDAO VendaDAO = new VendaDAO();

    public void addVenda(Venda venda) {
        VendaDAO.create(venda);
    }

    public Venda getVenda(int idVenda) {
        return org.example.DAO.VendaDAO.read(idVenda);
    }

    public void updateVenda(Venda venda) {
        VendaDAO.update(venda);
    }

    public void deleteVenda(int idVenda) {
        org.example.DAO.VendaDAO.delete(idVenda);
    }

    public List<Venda> getAllVenda() {
        return org.example.DAO.VendaDAO.getAll();
    }
}
