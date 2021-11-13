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
    private int cantSemaforos1 ;
    private int cantRojo1;
    private int cantAmarillo1;
    private int cantVerde1;
    private int cantSemaforos2 ;
    private int cantRojo2;
    private int cantAmarillo2;
    private int cantVerde2;
    
    private boolean estRojo1;
    private boolean estVerde1;
    private boolean estAmarillo1;
    private boolean estSemaforos2 ;
    private boolean estRojo2;
    private boolean estAmarillo2;
    private boolean estVerde2;

    public Cliente(int id, int cantSemaforos1, int cantRojo1, int cantAmarillo1, int cantVerde1, int cantSemaforos2, int cantRojo2, int cantAmarillo2, int cantVerde2, boolean estRojo1, boolean estVerde1, boolean estAmarillo1, boolean estSemaforos2, boolean estRojo2, boolean estAmarillo2, boolean estVerde2) {
        this.id = id;
        this.cantSemaforos1 = cantSemaforos1;
        this.cantRojo1 = cantRojo1;
        this.cantAmarillo1 = cantAmarillo1;
        this.cantVerde1 = cantVerde1;
        this.cantSemaforos2 = cantSemaforos2;
        this.cantRojo2 = cantRojo2;
        this.cantAmarillo2 = cantAmarillo2;
        this.cantVerde2 = cantVerde2;
        this.estRojo1 = estRojo1;
        this.estVerde1 = estVerde1;
        this.estAmarillo1 = estAmarillo1;
        this.estSemaforos2 = estSemaforos2;
        this.estRojo2 = estRojo2;
        this.estAmarillo2 = estAmarillo2;
        this.estVerde2 = estVerde2;
    }

    public Cliente() {
        this.id = 0;
        this.cantSemaforos1 = 0;
        this.cantRojo1 = 0;
        this.cantAmarillo1 = 0;
        this.cantVerde1 = 0;
        this.cantSemaforos2 = 0;
        this.cantRojo2 = 0;
        this.cantAmarillo2 = 0;
        this.cantVerde2 = 0;
        this.estRojo1 = false;
        this.estVerde1 = false;
        this.estAmarillo1 = false;
        this.estSemaforos2 = false;
        this.estRojo2 = false;
        this.estAmarillo2 = false;
        this.estVerde2 = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantSemaforos1() {
        return cantSemaforos1;
    }

    public void setCantSemaforos1(int cantSemaforos1) {
        this.cantSemaforos1 = cantSemaforos1;
    }

    public int getCantRojo1() {
        return cantRojo1;
    }

    public void setCantRojo1(int cantRojo1) {
        this.cantRojo1 = cantRojo1;
    }

    public int getCantAmarillo1() {
        return cantAmarillo1;
    }

    public void setCantAmarillo1(int cantAmarillo1) {
        this.cantAmarillo1 = cantAmarillo1;
    }

    public int getCantVerde1() {
        return cantVerde1;
    }

    public void setCantVerde1(int cantVerde1) {
        this.cantVerde1 = cantVerde1;
    }

    public int getCantSemaforos2() {
        return cantSemaforos2;
    }

    public void setCantSemaforos2(int cantSemaforos2) {
        this.cantSemaforos2 = cantSemaforos2;
    }

    public int getCantRojo2() {
        return cantRojo2;
    }

    public void setCantRojo2(int cantRojo2) {
        this.cantRojo2 = cantRojo2;
    }

    public int getCantAmarillo2() {
        return cantAmarillo2;
    }

    public void setCantAmarillo2(int cantAmarillo2) {
        this.cantAmarillo2 = cantAmarillo2;
    }

    public int getCantVerde2() {
        return cantVerde2;
    }

    public void setCantVerde2(int cantVerde2) {
        this.cantVerde2 = cantVerde2;
    }

    public boolean isEstRojo1() {
        return estRojo1;
    }

    public void setEstRojo1(boolean estRojo1) {
        this.estRojo1 = estRojo1;
    }

    public boolean isEstVerde1() {
        return estVerde1;
    }

    public void setEstVerde1(boolean estVerde1) {
        this.estVerde1 = estVerde1;
    }

    public boolean isEstAmarillo1() {
        return estAmarillo1;
    }

    public void setEstAmarillo1(boolean estAmarillo1) {
        this.estAmarillo1 = estAmarillo1;
    }

    public boolean isEstSemaforos2() {
        return estSemaforos2;
    }

    public void setEstSemaforos2(boolean estSemaforos2) {
        this.estSemaforos2 = estSemaforos2;
    }

    public boolean isEstRojo2() {
        return estRojo2;
    }

    public void setEstRojo2(boolean estRojo2) {
        this.estRojo2 = estRojo2;
    }

    public boolean isEstAmarillo2() {
        return estAmarillo2;
    }

    public void setEstAmarillo2(boolean estAmarillo2) {
        this.estAmarillo2 = estAmarillo2;
    }

    public boolean isEstVerde2() {
        return estVerde2;
    }

    public void setEstVerde2(boolean estVerde2) {
        this.estVerde2 = estVerde2;
    }
    
  
    @Override
    public String toString() {
        return String.valueOf(id); //To change body of generated methods, choose Tools | Templates.
    }
}
