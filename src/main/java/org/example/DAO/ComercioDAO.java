package org.example.DAO;

import org.example.model.Comercio;
import org.example.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComercioDAO {
    public void create(Comercio comercio) {
        String sql = "INSERT INTO comercio (CNPJ, nome_da_empresa, endereco_barraca, endereco_atual_empresa) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, comercio.getCNPJ());
            pstmt.setString(2, comercio.getNomeDaEmpresa());
            pstmt.setString(3, comercio.getEnderecoBarraca());
            pstmt.setString(4, comercio.getEnderecoAtualEmpresa());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Comercio read(String CNPJ) {
        String sql = "SELECT * FROM comercio WHERE CNPJ = ?";
        Comercio comercio = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, CNPJ);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                comercio = new Comercio();
                comercio.setCNPJ(rs.getString("CNPJ"));
                comercio.setNomeDaEmpresa(rs.getString("nome_da_empresa"));
                comercio.setEnderecoBarraca(rs.getString("endereco_barraca"));
                comercio.setEnderecoAtualEmpresa(rs.getString("endereco_atual_empresa"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comercio;
    }

    public void update(Comercio comercio) {
        String sql = "UPDATE comercio SET nome_da_empresa = ?, endereco_barraca = ?, endereco_atual_empresa = ? WHERE CNPJ = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, comercio.getNomeDaEmpresa());
            pstmt.setString(2, comercio.getEnderecoBarraca());
            pstmt.setString(3, comercio.getEnderecoAtualEmpresa());
            pstmt.setString(4, comercio.getCNPJ());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String CNPJ) {
        String sql = "DELETE FROM comercio WHERE CNPJ = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, CNPJ);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Comercio> getAll() {
        List<Comercio> comercios = new ArrayList<>();
        String sql = "SELECT * FROM comercio";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Comercio comercio = new Comercio();
                comercio.setCNPJ(rs.getString("CNPJ"));
                comercio.setNomeDaEmpresa(rs.getString("nome_da_empresa"));
                comercio.setEnderecoBarraca(rs.getString("endereco_barraca"));
                comercio.setEnderecoAtualEmpresa(rs.getString("endereco_atual_empresa"));
                comercios.add(comercio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comercios;
    }
}
