package org.example.DAO;

import org.example.model.Proprietario;
import org.example.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProprietarioDAO {
    public void create(Proprietario proprietario) {
        String sql = "INSERT INTO proprietario (CPF, nome, endereco, CNPJ_comercio) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, proprietario.getCPF());
            pstmt.setString(2, proprietario.getNome());
            pstmt.setString(3, proprietario.getEndereco());
            pstmt.setString(4, proprietario.getCNPJComercio());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Proprietario read(String CPF) {
        String sql = "SELECT * FROM proprietario WHERE CPF = ?";
        Proprietario proprietario = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, CPF);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                proprietario = new Proprietario();
                proprietario.setCPF(rs.getString("CPF"));
                proprietario.setNome(rs.getString("nome"));
                proprietario.setEndereco(rs.getString("endereco"));
                proprietario.setCNPJComercio(rs.getString("CNPJ_comercio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return proprietario;
    }

    public void update(Proprietario proprietario) {
        String sql = "UPDATE proprietario SET nome = ?, endereco = ?, CNPJ_comercio = ? WHERE CPF = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, proprietario.getNome());
            pstmt.setString(2, proprietario.getEndereco());
            pstmt.setString(3, proprietario.getCNPJComercio());
            pstmt.setString(4, proprietario.getCPF());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String CPF) {
        String sql = "DELETE FROM proprietario WHERE CPF = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, CPF);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Proprietario> getAll() {
        List<Proprietario> proprietarios = new ArrayList<>();
        String sql = "SELECT * FROM proprietario";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Proprietario proprietario = new Proprietario();
                proprietario.setCPF(rs.getString("CPF"));
                proprietario.setNome(rs.getString("nome"));
                proprietario.setEndereco(rs.getString("endereco"));
                proprietario.setCNPJComercio(rs.getString("CNPJ_comercio"));
                proprietarios.add(proprietario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return proprietarios;
    }
}
