package org.example.DAO;

import org.example.model.Venda;
import org.example.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {
    public void create(Venda venda) {
        String sql = "INSERT INTO vendas (CNPJ_comercio, valor_venda, data_venda) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, venda.getCNPJComercio());
            pstmt.setDouble(2, venda.getValorVenda());
            pstmt.setDate(3, venda.getDataVenda());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Venda read(int idVenda) {
        String sql = "SELECT * FROM vendas WHERE id_venda = ?";
        Venda venda = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idVenda);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                venda = new Venda();
                venda.setIdVenda(rs.getInt("id_venda"));
                venda.setCNPJComercio(rs.getString("CNPJ_comercio"));
                venda.setValorVenda(rs.getDouble("valor_venda"));
                venda.setDataVenda(rs.getDate("data_venda"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return venda;
    }

    public void update(Venda venda) {
        String sql = "UPDATE vendas SET CNPJ_comercio = ?, valor_venda = ?, data_venda = ? WHERE id_venda = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, venda.getCNPJComercio());
            pstmt.setDouble(2, venda.getValorVenda());
            pstmt.setDate(3, venda.getDataVenda());
            pstmt.setInt(4, venda.getIdVenda());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int idVenda) {
        String sql = "DELETE FROM vendas WHERE id_venda = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idVenda);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Venda> getAll() {
        List<Venda> vendas = new ArrayList<>();
        String sql = "SELECT * FROM vendas";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();
                venda.setIdVenda(rs.getInt("id_venda"));
                venda.setCNPJComercio(rs.getString("CNPJ_comercio"));
                venda.setValorVenda(rs.getDouble("valor_venda"));
                venda.setDataVenda(rs.getDate("data_venda"));
                vendas.add(venda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vendas;
    }
}
