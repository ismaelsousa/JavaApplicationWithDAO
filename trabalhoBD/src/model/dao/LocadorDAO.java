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
public class LocadorDAO {

    private Connection con = null;

    public LocadorDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean save(Locador locador) {
        String sql = "INSERT INTO locador(nome,cpf,telefone) VALUES(?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, locador.getNome());
            stmt.setInt(2, locador.getCpf());
            stmt.setString(3, locador.getTelefone());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public boolean updateNome(Locador locador) {
        String sql = "UPDATE locador SET nome = ? WHERE id = ? ";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, locador.getNome());
            stmt.setInt(2, locador.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public boolean delete(Locador locador) {
        String sql = "DELETE FROM locador WHERE id = ? ";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, locador.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public ArrayList<Locador> selectLocadores() {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Locador> locadores = new ArrayList<>();
        String sql = "SELECT * FROM locador";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Locador l = new Locador();                
                l.setCpf(rs.getInt("cpf"));
                l.setNome(rs.getString("nome"));
                l.setId(rs.getInt("id"));
                locadores.add(l);
            }
            
        } catch (SQLException ex) {
            System.out.println("erro ao fazer select de locador");
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return locadores;

    }

    public static void main(String[] args) {
        
        LocadorDAO d = new LocadorDAO();
        ArrayList<Locador> list = d.selectLocadores();
        
        for (Locador locador : list) {
            System.out.println("locador:"+locador.getNome());
            
        }
    }

}
