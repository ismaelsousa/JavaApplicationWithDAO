/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;



/**
 *
 * @author ismae
 */
public class Aluguel {
    private int id;
    private Apartamento apartamento;
    private Contrato contrato;

    public Aluguel(Apartamento apartamento, Contrato contrato) {
        this.id = id;
        this.apartamento = apartamento;
        this.contrato = contrato;
                
    }

    public Aluguel() {
       
    }

    public Aluguel(int aInt) {
       this.id = aInt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Apartamento getApartamento() {
        return apartamento;
    }

    public void setApartamento(Apartamento apartamento) {
        this.apartamento = apartamento;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
    
    
    
}
