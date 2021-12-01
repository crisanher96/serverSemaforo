package logica;

public class ResponseServer {
    private int llave;
    private int group_id;
    private boolean luz_roja;
    private boolean luz_amarilla;
    private boolean luz_verde;
    private int client_id;
    private int serverId;

    public ResponseServer(int llave, int group_id, boolean luz_roja, boolean luz_amarilla, boolean luz_verde, int client_id, int serverId) {
        this.llave = llave;
        this.group_id = group_id;
        this.luz_roja = luz_roja;
        this.luz_amarilla = luz_amarilla;
        this.luz_verde = luz_verde;
        this.client_id = client_id;
        this.serverId = serverId;
    }

    public int getLlave() {
        return llave;
    }

    public int getGroup_id() {
        return group_id;
    }

    public boolean isLuz_roja() {
        return luz_roja;
    }

    public boolean isLuz_amarilla() {
        return luz_amarilla;
    }

    public boolean isLuz_verde() {
        return luz_verde;
    }

    public int getClient_id() {
        return client_id;
    }

    public int getServerId() {
        return serverId;
    }

    public void setLlave(int llave) {
        this.llave = llave;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public void setLuz_roja(boolean luz_roja) {
        this.luz_roja = luz_roja;
    }

    public void setLuz_amarilla(boolean luz_amarilla) {
        this.luz_amarilla = luz_amarilla;
    }

    public void setLuz_verde(boolean luz_verde) {
        this.luz_verde = luz_verde;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }
    
    
    
}

