
package logica;

import com.google.gson.*;
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
import org.json.*;


public class Hilo extends Thread{

    private Socket host;
    private DataOutputStream datosSalida;
    private DataInputStream input_stream;
    private BufferedReader datosEntrada, inputStream;
    public static int NUM_CLIENTES = 0;
    private int clienteNo, salir=0;
    protected String mensajeRecibido;
    private Cliente cliente;
    byte buffer[];  // Para almacenar lo que llegue del cliente
    
    
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
        // Buffer input stream
        try { 
        input_stream=new DataInputStream(host.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }         
    }

    @Override
    public void run() {
    System.out.println("Hola "+ clienteNo + "!");
    JSONObject mensaje = new JSONObject();
    while(!(host.isClosed())){
        try { 
                buffer = new byte[1024];
                input_stream.read(buffer);
                mensajeRecibido = new String(buffer).trim();
                if (!(mensajeRecibido.equals(""))) {
                    JsonElement root = new JsonParser().parse(mensajeRecibido);
                    String request_type = root.getAsJsonObject().get("peticion").getAsString();
                    String info = root.getAsJsonObject().get("info").toString();
                    System.out.println(request_type); 
                    System.out.println(info);
                    Gson gson = new Gson();
                    Json json = new Json(request_type, info);
                    
                    switch (json.getPeticion()) {
                        case "connect": 
                            System.out.println("Cliente Conectado");
                            mensaje.put("mensaje","Cliente Conectado");
                            datosSalida = new DataOutputStream(host.getOutputStream());
                            datosSalida.writeUTF(mensaje.toString());
                        break;
                        case "disconnect":  
                            System.out.println("Cliente Desconectado");
                            mensaje.put("mensaje","Cliente Desconectado");
                            datosSalida = new DataOutputStream(host.getOutputStream());
                            datosSalida.writeUTF(mensaje.toString());
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
                            new ResponseClient(2, getCliente().isEstRojo1(), getCliente().isEstAmarillo2(), getCliente().isEstVerde2())
                            };
                            String data = gson.toJson(respuestaCliente);
                            datosSalida = new DataOutputStream(host.getOutputStream());
                            datosSalida.write(data.getBytes());
                        break;
                        default: 
                            System.out.println("Request type No Valida");
                            mensaje.put("mensaje","Request type No Valida");
                            datosSalida = new DataOutputStream(host.getOutputStream());
                            datosSalida.writeUTF(mensaje.toString());
                        break;
                    }
        
                }
        
        } catch (IOException e) {
            e.printStackTrace();
        }                   
    }    
    }
}
