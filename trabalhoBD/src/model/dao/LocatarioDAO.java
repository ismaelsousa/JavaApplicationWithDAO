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

/**
 *
 * @author ismae
 */
public class LocatarioDAO {

    private Connection con = null;

    public LocatarioDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean save(Locatario locatario) {
        String sql = "INSERT INTO locatario(nome,cpf,telefone) VALUES(?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, locatario.getNome());
            stmt.setInt(2, locatario.getCpf());
            stmt.setString(3, locatario.getTelefone());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean updateNome(Locatario locatario) {
        String sql = "UPDATE locatario SET nome = ? WHERE id = ? ";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, locatario.getNome());
            stmt.setInt(2, locatario.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
     public boolean delete(Locatario locatario) {
        String sql = "DELETE FROM locatario WHERE id = ? ";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, locatario.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
     
     public ArrayList<Locatario> selectLocadores() {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Locatario> locatarios = new ArrayList<>();
        String sql = "SELECT * FROM locatario";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Locatario l = new Locatario();                
                l.setCpf(rs.getInt("cpf"));
                l.setNome(rs.getString("nome"));
                l.setId(rs.getInt("id"));
                locatarios.add(l);
            }
            
        } catch (SQLException ex) {
            System.out.println("erro ao fazer select de locatarios");
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return locatarios;

    }

    public static void main(String[] args) {
      
        LocatarioDAO d = new LocatarioDAO();            
        d.delete(new Locatario(3, "", 10, "")); 
    }

}
