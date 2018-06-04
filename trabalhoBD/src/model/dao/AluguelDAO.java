/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * CRUD
 *
 * @author ismae
 */
public class AluguelDAO {

    private Connection con = null;

    public AluguelDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean save(Aluguel aluguel) {
        String sql = "INSERT INTO aluguel(id_apartamento,id_contrato) VALUES(?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, aluguel.getApartamento().getId());
            stmt.setInt(2, aluguel.getContrato().getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public boolean updateApartamento(Aluguel aluguel) {
        String sql = "UPDATE aluguel SET id_apartamento = ? WHERE id = ? ";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, aluguel.getApartamento().getId());
            stmt.setInt(2, aluguel.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public boolean delete(Aluguel aluguel) {
        String sql = "DELETE FROM aluguel WHERE id = ? ";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);            
            stmt.setInt(1, aluguel.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public ArrayList<Aluguel> findAll() {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Aluguel> algueis = new ArrayList<>();
        String sql = "SELECT * FROM aluguel";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Apartamento ap = new Apartamento();
                ap.setId(rs.getInt("id_apartamento"));
                Contrato c = new Contrato();
                c.setId(rs.getInt("id_contrato"));
                Aluguel a = new Aluguel(ap, c);
                algueis.add(a);
            }
        } catch (SQLException ex) {
            System.out.println("erro ao fazer select de aluguel");
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return algueis;
    }

}
