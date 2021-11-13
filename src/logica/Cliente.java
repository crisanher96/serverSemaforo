/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Christian
 */
public class Cliente {
    
    private int id ; 
    private int cantSemaforos ;
    private int cantRojo;
    private int cantAmarillo;
    private int cantVerde;

    public Cliente(int id, int cantSemaforos, int cantRojo, int cantAmarillo, int cantVerde) {
        this.id = id;
        this.cantSemaforos = cantSemaforos;
        this.cantRojo = cantRojo;
        this.cantAmarillo = cantAmarillo;
        this.cantVerde = cantVerde;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantSemaforos() {
        return cantSemaforos;
    }

    public void setCantSemaforos(int cantSemaforos) {
        this.cantSemaforos = cantSemaforos;
    }

    public int getCantRojo() {
        return cantRojo;
    }

    public void setCantRojo(int cantRojo) {
        this.cantRojo = cantRojo;
    }

    public int getCantAmarillo() {
        return cantAmarillo;
    }

    public void setCantAmarillo(int cantAmarillo) {
        this.cantAmarillo = cantAmarillo;
    }

    public int getCantVerde() {
        return cantVerde;
    }

    public void setCantVerde(int cantVerde) {
        this.cantVerde = cantVerde;
    }
  
    @Override
    public String toString() {
        return String.valueOf(id); //To change body of generated methods, choose Tools | Templates.
    }
}
