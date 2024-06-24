package org.example.DAO;

import org.example.model.Sorteio;
import org.example.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SorteioDAO {
    public void create(Sorteio sorteio) {
        String sql = "INSERT INTO sorteio (data_sorteio, CNPJ_ganhador) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDate(1, sorteio.getDataSorteio());
            pstmt.setString(2, sorteio.getCNPJGanhador());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Sorteio read(int idSorteio) {
        String sql = "SELECT * FROM sorteio WHERE id_sorteio = ?";
        Sorteio sorteio = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idSorteio);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                sorteio = new Sorteio();
                sorteio.setIdSorteio(rs.getInt("id_sorteio"));
                sorteio.setDataSorteio(rs.getDate("data_sorteio"));
                sorteio.setCNPJGanhador(rs.getString("CNPJ_ganhador"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sorteio;
    }

    public void update(Sorteio sorteio) {
        String sql = "UPDATE sorteio SET data_sorteio = ?, CNPJ_ganhador = ? WHERE id_sorteio = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDate(1, sorteio.getDataSorteio());
            pstmt.setString(2, sorteio.getCNPJGanhador());
            pstmt.setInt(3, sorteio.getIdSorteio());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int idSorteio) {
        String sql = "DELETE FROM sorteio WHERE id_sorteio = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idSorteio);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Sorteio> getAll() {
        List<Sorteio> sorteios = new ArrayList<>();
        String sql = "SELECT * FROM sorteio";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Sorteio sorteio = new Sorteio();
                sorteio.setIdSorteio(rs.getInt("id_sorteio"));
                sorteio.setDataSorteio(rs.getDate("data_sorteio"));
                sorteio.setCNPJGanhador(rs.getString("CNPJ_ganhador"));
                sorteios.add(sorteio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sorteios;
    }
}
