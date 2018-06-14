/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Beans.Aluguel;
import Beans.Apartamento;
import Beans.ConnectionFactory;
import Beans.Contrato;
import Beans.Mensalidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ismae
 */
public class DAOMensalidade {

    private Connection con = null;

    public DAOMensalidade() {
        con = ConnectionFactory.getConnection();
    }

    public boolean save(Mensalidade mensal) {
        String sql = "INSERT INTO mensalidade(id_aluguel,valor,status,mes) VALUES(?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, mensal.getAluguel().getId());
            stmt.setFloat(2, mensal.getValor());
            stmt.setString(3, mensal.getStatus());
            stmt.setString(4, mensal.getMes());

            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(Mensalidade mensal) {
        String sql = "UPDATE mensalidade SET id_aluguel = ?,valor = ?,status = ?,mes = ? WHERE id = ? ";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, mensal.getAluguel().getId());
            stmt.setFloat(2, mensal.getValor());
            stmt.setString(3, mensal.getStatus());
            stmt.setString(4, mensal.getMes());

            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public boolean delete(Mensalidade mensal) {
        String sql = "DELETE FROM mensalidade WHERE id = ? ";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, mensal.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public ArrayList<Mensalidade> findAll() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Mensalidade> list = new ArrayList<>();
        String sql = "SELECT * FROM mensalidade";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Mensalidade m = new Mensalidade();
                m.setId(rs.getInt("id"));
                m.setAluguel(new Aluguel(rs.getInt("id_aluguel")));
                m.setValor(rs.getFloat("valor"));
                m.setMes(rs.getString("mes"));
                m.setStatus(rs.getString("status"));
                list.add(m);
            }
        } catch (SQLException ex) {
            System.out.println("erro ao fazer select de aluguel");
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return list;
    }
}
