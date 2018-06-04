/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Date;

/**
 *
 * @author ismae
 */
public class Mensalidade {
    private int id;
    private Aluguel aluguel;
    private float valor;
    private String status;
    private Date mes;

    public Mensalidade(Aluguel aluguel, float valor, String status, Date mes) {     
        this.aluguel = aluguel;
        this.valor = valor;
        this.status = status;
        this.mes = mes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getMes() {
        return mes;
    }

    public void setMes(Date mes) {
        this.mes = mes;
    }
    
    
    
}
