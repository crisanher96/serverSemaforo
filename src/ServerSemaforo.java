
import presentacion.Modelo;

public class ServerSemaforo {

    private Modelo miApp;
    
    public ServerSemaforo(){
        miApp = new Modelo();
        miApp.iniciar();   
    }
    
    public static void main(String[] args) {
        new ServerSemaforo();
    }
    
}