
package logica;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Conexion {
    
    private ServerSocket server;
    private Socket cliente;
    private int puerto;
    private boolean conectarActivo;
    
    public Conexion (){
        puerto = 5000;
        conectarActivo = true;
    }
    
    public void conectar() throws IOException {
                       
        // Crear el servidor
        server = new ServerSocket(puerto);
        
        while(conectarActivo){
            //Esperar a que alguien se conecte        
            cliente = server.accept();                    
            // Alguien se conectó
            new Hilo(cliente).start();
        }
        
    }
    
}
