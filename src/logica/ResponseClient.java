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
public class ResponseClient {
    private int group_id;
    private boolean luz_roja;
    private boolean luz_amarilla;
    private boolean luz_verde;

    public ResponseClient(int group_id, boolean luz_roja, boolean luz_amarilla, boolean luz_verde) {
        this.group_id = group_id;
        this.luz_roja = luz_roja;
        this.luz_amarilla = luz_amarilla;
        this.luz_verde = luz_verde;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public boolean isLuz_roja() {
        return luz_roja;
    }

    public void setLuz_roja(boolean luz_roja) {
        this.luz_roja = luz_roja;
    }

    public boolean isLuz_amarilla() {
        return luz_amarilla;
    }

    public void setLuz_amarilla(boolean luz_amarilla) {
        this.luz_amarilla = luz_amarilla;
    }

    public boolean isLuz_verde() {
        return luz_verde;
    }

    public void setLuz_verde(boolean luz_verde) {
        this.luz_verde = luz_verde;
    }
    
    
}
