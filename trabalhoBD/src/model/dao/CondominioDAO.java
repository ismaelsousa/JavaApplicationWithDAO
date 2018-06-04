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
public class CondominioDAO {

    private Connection con = null;

    public CondominioDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean save(Condominio condominio) {
        String sql = "INSERT INTO condominio(id_locador,rua,numero) VALUES(?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, condominio.getLocador().getId());
            stmt.setString(2, condominio.getRua());
            stmt.setInt(3, condominio.getNumero());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public boolean updateCondominio(Condominio condominio) {
        String sql = "UPDATE condominio SET id_locador = ? WHERE id = ? ";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, condominio.getLocador().getId());
            stmt.setInt(2, condominio.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public boolean delete(Condominio condominio) {
        String sql = "DELETE FROM condominio WHERE id = ? ";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, condominio.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public ArrayList<Condominio> findAll() {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Condominio> condominios = new ArrayList<>();
        String sql = "select * from view_condominio"; 
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Condominio c = new Condominio();
                Locador a =new Locador();
                
                a.setId(rs.getInt("lid"));
                a.setNome(rs.getString("lnome"));
                a.setCpf(rs.getInt("lcpf"));
                a.setTelefone(rs.getString("ltel"));                
                                
                c.setLocador(a);
                c.setId(rs.getInt("id"));                
                c.setRua(rs.getString("rua"));
                c.setNumero(rs.getInt("numero"));
                condominios.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("erro ao fazer select de aluguel");
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return condominios;
    }
    
    

    public static void main(String[] args) {
        CondominioDAO d = new CondominioDAO();
       
        ArrayList<Condominio> c = d.findAll();
        for (Condominio condominio : c) {
            System.out.println(condominio.getRua());
        }
        
        
    }

}
