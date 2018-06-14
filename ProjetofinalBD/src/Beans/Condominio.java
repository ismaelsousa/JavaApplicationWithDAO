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
public class Condominio {
    private int id;
    private Locador locador;
    private String rua;
    private int numero;

    public Condominio(Locador locador, String rua, int numero) {        
        this.locador = locador;
        this.rua = rua;
        this.numero = numero;
    }

   public Condominio() {
      
    }

  public  Condominio(int id) {
       this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Locador getLocador() {
        return locador;
    }

    public void setLocador(Locador locador) {
        this.locador = locador;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
    
    
}
