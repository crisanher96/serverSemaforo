
package logica;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Hilo extends Thread{

    private Socket host;
    private DataOutputStream datosSalida;
    public static int NUM_CLIENTES = 0;
    private int clienteNo;
    
    public Hilo(Socket c) {
        host = c;
        NUM_CLIENTES++;
        clienteNo = NUM_CLIENTES;
    }

    @Override
    public void run() {
        String mensaje = "Hola "+ clienteNo + "!";
        
        try {
            // Capturo el flujo de salida y lo asocio al dato de salida
            datosSalida = new DataOutputStream(host.getOutputStream());
        
            // opero con los mensajes
            datosSalida.write(mensaje.getBytes()); // ESTE ES EL PROTOCOLO
            
            // Se cierra todo
            datosSalida.close();
            host.close();
            
        } catch (IOException ex) {            
        }        
        
    }
    
    
    
    
}
