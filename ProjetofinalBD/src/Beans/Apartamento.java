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
public class Apartamento {
    private int id;
    private int qtdQuarto;
    private String estado;
    private Condominio condominio;

    public Apartamento(int qtdQuarto, String estado, Condominio condominio) {
        this.id = id;
        this.qtdQuarto = qtdQuarto;
        this.estado = estado;
        this.condominio = condominio;                   
    }

   public Apartamento() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQtdQuarto() {
        return qtdQuarto;
    }

    public void setQtdQuarto(int qtdQuarto) {
        this.qtdQuarto = qtdQuarto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }
    
}
