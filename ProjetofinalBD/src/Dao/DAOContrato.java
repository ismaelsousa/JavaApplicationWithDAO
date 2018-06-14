/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Beans.ConnectionFactory;
import Beans.Contrato;
import Beans.Contrato;
import Beans.Locador;
import Beans.Locatario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author ismae
 */
public class DAOContrato {

    private Connection con = null;

    public DAOContrato() {
        con = ConnectionFactory.getConnection();
    }

    public boolean save(Contrato contrato) {
        String sql = "INSERT INTO contrato(data_inicio, data_fim, id_locatario, id_locador,status) VALUES(?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, contrato.getDataInicio());
            stmt.setString(2, contrato.getDataFim());
            stmt.setInt(3, contrato.getLocatario().getId());
            stmt.setInt(4, contrato.getLocador().getId());
            stmt.setString(5, contrato.getStatus());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(Contrato contrato) {
        String sql = "UPDATE contrato SET data_inicio = ?, data_fim = ?, id_locatario= ?, id_locador = ?, status = ? WHERE id = ? ";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, contrato.getDataInicio());
            stmt.setString(2, contrato.getDataFim());
            stmt.setInt(3, contrato.getLocatario().getId());
            stmt.setInt(4, contrato.getLocador().getId());
            stmt.setString(5, contrato.getStatus());
            stmt.setInt(6, contrato.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public boolean delete(Contrato contrato) {
        String sql = "DELETE FROM contrato WHERE id = ? ";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, contrato.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
     public ArrayList<Contrato> findAll() {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Contrato> Contratos = new ArrayList<>();
        String sql = "select * from contrato"; 
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) { 
                Contrato c = new Contrato();
                c.setId(rs.getInt("id"));
                c.setDataInicio(rs.getString("data_inicio"));
                c.setDataFim(rs.getString("data_fim"));
                c.setLocador(new Locador(rs.getInt("id_locador")));
                c.setLocatario(new Locatario(rs.getInt("id_locatario")));
                c.setStatus(rs.getString("status"));
                
                Contratos.add(c);
                
                 
                
            }
        } catch (SQLException ex) {
            System.out.println("erro ao fazer select de aluguel");
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return Contratos;
    }
    

    //falta o select 
    public static void main(String[] args) {
       

    }

}

