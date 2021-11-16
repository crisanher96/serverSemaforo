
package logica;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;



public class Hilo extends Thread{

    private Socket host;
    private DataOutputStream datosSalida;
    private BufferedReader datosEntrada;
    public static int NUM_CLIENTES = 0;
    private int clienteNo, salir=0;
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
        
        
        try {
            
            //SE LEE LA ENTRADA
            datosEntrada = new BufferedReader(new InputStreamReader(host.getInputStream() ));
            
            while( (mensajeRecibido = datosEntrada.readLine()) != null && salir == 0 ) ////Mientras haya mensajes desde el cliente
            {
//               Scanner s = new Scanner(host.getInputStream()).useDelimiter("\\A");
//               String result = s.hasNext() ? s.next() : "";
//            
                System.out.println("----------- MENSAJE RECIBIDO --------------");  
                System.out.println(mensajeRecibido);  
                System.out.println("-------------------------------------------");  
                try {
                        Gson gson = new Gson();
                        Json json = gson.fromJson(mensajeRecibido, Json.class);
                        String opcion = "";
                        if(json.getPeticion()!= null) opcion = json.getPeticion();
                            
                        switch (opcion) {
                            case "connect": 
                                mensaje = "Cliente Conectado";
                                datosSalida = new DataOutputStream(host.getOutputStream());
                                datosSalida.write((mensaje +"\n").getBytes());
                            break;
                            case "disconnect":  
                                System.out.println("Cliente Desconectado");
                                mensaje = "Cliente Desconectado";
                                datosSalida = new DataOutputStream(host.getOutputStream());
                                datosSalida.write((mensaje +"\n").getBytes());
                                salir=1;
                                datosSalida.close();
                                datosEntrada.close();
                                host.close();
                            break;
                            case "update":
                                Gson gsonF = new Gson();
                                ClienteTemp[] clientesTemp = gsonF.fromJson(json.getInfo(),ClienteTemp[].class);
                                System.out.println("-------------------------------------------");
                                System.out.println(clientesTemp[0].getCant_semaforos());
                                
                                getCliente().setId(clientesTemp[0].getClient_id());
                                getCliente().setCantSemaforos1(clientesTemp[0].getCant_semaforos());
                                getCliente().setCantSemaforos2(clientesTemp[1].getCant_semaforos());
                                getCliente().setCantRojo1(clientesTemp[0].getLuz_red_broken());
                                getCliente().setCantRojo2(clientesTemp[1].getLuz_red_broken());
                                getCliente().setCantAmarillo1(clientesTemp[0].getLuz_yellow_broken());
                                getCliente().setCantAmarillo2(clientesTemp[1].getLuz_yellow_broken());
                                getCliente().setCantVerde1(clientesTemp[0].getLuz_green_broken());
                                getCliente().setCantVerde2(clientesTemp[1].getLuz_green_broken());
                                
                                ResponseClient[] respuestaCliente = {
                                new ResponseClient(1, getCliente().isEstRojo1(), getCliente().isEstAmarillo1(), getCliente().isEstVerde1()),
                                new ResponseClient(2, getCliente().isEstRojo2(), getCliente().isEstAmarillo2(), getCliente().isEstVerde2())
                            };
                                 

                                mensaje = gson.toJson(respuestaCliente);
                                datosSalida = new DataOutputStream(host.getOutputStream());
                                //datosSalida.write(("{  \"Data\" : " +mensaje+"}" +"\n").getBytes());
                                datosSalida.write((mensaje+"\n").getBytes());
                            break;
                            default: 
                                System.out.println("Opcion No Valida");
                                mensaje = "Opcion No Valida";
                                datosSalida = new DataOutputStream(host.getOutputStream());
                                datosSalida.write((mensaje +"\n").getBytes());
                            break;
                        }
                    } catch(JsonSyntaxException e){
                        System.out.println("Json Con Estructura Erronea");
                        mensaje = "Json Con Estructura Erronea";
                        datosSalida = new DataOutputStream(host.getOutputStream());
                        datosSalida.write((mensaje +"\n").getBytes());
                    }
                    
                   
            }
        } catch (IOException ex) {
            System.out.println("Mensaje Incorrecto");
        }        
        
    }
    
    
    
    
}
