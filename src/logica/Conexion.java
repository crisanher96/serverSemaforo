
package logica;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;


public class Conexion extends Thread {
    
    private ServerSocket server;
    private Socket cliente;
    private int puerto;
    private boolean conectarActivo;
    private List<Thread> listaTareas ;
    private List<String> listaClientes ;

    public List<Thread> getListaTareas() {
        if(listaTareas == null){
            listaTareas = new ArrayList<Thread>();
        }
        return listaTareas;
    }

    public List<String> getListaClientes() {
        if(listaClientes == null){
            listaClientes = new ArrayList<String>();
        }
        listaClientes.clear();
        for(Thread item : getListaTareas()){
//            listaClientes.add(item.getName());
            Hilo hilo = (Hilo)item;
            if(hilo.isAlive())
                listaClientes.add( String.valueOf(hilo.getCliente().getId()));
        }
        
        return listaClientes;
    }
    
    
    
    public Conexion (){
        puerto = 5000;
        conectarActivo = true;
    }
    
    @Override
    public void run() {
        try {
             System.out.println("Creando socket puerto " + String.valueOf(puerto));
            server = new ServerSocket(puerto);
            while(conectarActivo){
            //Esperar a que alguien se conecte        
            cliente = server.accept();                    
            // Alguien se conectó
            Thread tarea = new Hilo(cliente);
            tarea.start();
            getListaTareas().add(tarea);
            }
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error Server");
        }
    }
   
    
    
//    public void conectar() throws IOException {
//                       
//        // Crear el servidor
//        server = new ServerSocket(puerto);
//        
//        while(conectarActivo){
//            //Esperar a que alguien se conecte        
//            cliente = server.accept();                    
//            // Alguien se conectó
//            new Hilo(cliente).start();
//        }
//        
//    }
    
}
