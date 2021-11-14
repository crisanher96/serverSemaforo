
package logica;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;


public class Hilo extends Thread{

    private Socket host;
    private DataOutputStream datosSalida;
    private BufferedReader datosEntrada;
    public static int NUM_CLIENTES = 0;
    private int clienteNo;
    protected String mensajeRecibido;
    private Cliente cliente;
    
    public Cliente getCliente() {
        if(cliente == null){
            cliente = new Cliente();
        }
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Hilo(Socket c) {
        host = c;
        NUM_CLIENTES++;
        clienteNo = NUM_CLIENTES;
    }

    @Override
    public void run() {
        String mensaje = "Hola "+ clienteNo + "!";
        getCliente().setId(clienteNo);
        
        try {
            
            //SE LEE LA ENTRADA
            datosEntrada = new BufferedReader(new InputStreamReader(host.getInputStream()));
            while((mensajeRecibido = datosEntrada.readLine()) != null  ) //Mientras haya mensajes desde el cliente
            {
                     
                    
                    try {
                        Gson gson = new Gson(); 
                        ClienteTemp[] clientesTemp = gson.fromJson(mensajeRecibido,ClienteTemp[].class); 
                        System.out.println("-------------------------------------------");
                        System.out.println(clientesTemp[0].getClient_id());
                    } catch(JsonSyntaxException e){
                        System.out.println("Json Con Estructura Erronea");
                    }
                    datosSalida = new DataOutputStream(host.getOutputStream());
                    datosSalida.write(mensaje.getBytes());
                    
                    System.out.println(cliente.isEstRojo1());
                    
                    
                /*//Se muestra por pantalla el mensaje recibido
                System.out.println("Mensaje Recibido: "+mensajeRecibido);
                datosSalida = new DataOutputStream(host.getOutputStream());
                datosSalida.write(mensaje.getBytes());*/
                if(mensajeRecibido.equals("Salir")){
                    System.out.println("Cliente Desconectado");
                    break;
                }
            }
            // Capturo el flujo de salida y lo asocio al dato de salida
             // ESTE ES EL PROTOCOLO
             
            datosSalida.close();
            datosEntrada.close();
            host.close();
                      
        } catch (IOException ex) {
            System.out.println("Mensaje Incorrecto");
        }        
        
    }
    
    
    
    
}
