/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import Connection.ConnectionFactory;
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
public class ContratoDAO {

    private Connection con = null;

    public ContratoDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean save(Contrato contrato) {
        String sql = "INSERT INTO contrato(data_inicio, data_fim, id_locatario, id_locador,status) VALUES(?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, contrato.getDataInicio());
            stmt.setDate(2, contrato.getDataFim());
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

    public boolean updateContrato(Contrato contrato) {
        String sql = "UPDATE contrato SET data_inicio = ?, data_fim = ?, id_locatario= ?, id_locador = ?, status = ? WHERE id = ? ";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, contrato.getDataInicio());
            stmt.setDate(2, contrato.getDataFim());
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
        String sql = "select * from view_apartamento"; 
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {            
                 
                
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
        Locador loc = new Locador(2);
        Locatario loca = new Locatario(4);
        java.sql.Date a = new Date(1999, 12, 3);
        Contrato cont = new Contrato(a, a, loca, loc, "mudou");
        cont.setId(2);
        ContratoDAO dao = new ContratoDAO();
        dao.delete(cont);

    }

}

