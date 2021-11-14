
package presentacion;

import java.io.IOException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import logica.Conexion;
import logica.LogicaPrincipal;
import logica.Hilo;

public class Modelo {
    
    DefaultComboBoxModel<String> listaCombo = new DefaultComboBoxModel<>();
    private Vista ventanaPrincipal;
    private LogicaPrincipal sistema;
    
    private Conexion conexion;
    
    // Conexion a logica
    public Conexion getMiSistema() {
        if(conexion == null){
            conexion = new Conexion();
        }
        return conexion;
    }
    
    // Conexion a logica
    protected LogicaPrincipal getSistema() {
        if(sistema == null){
            sistema = new LogicaPrincipal();
        }
        return sistema;
    }
    
    public void setListaClientes(){
        listaCombo. removeAllElements();
        getMiSistema().getListaClientes().forEach(item -> {
            listaCombo.addElement(item);
        });
    }
    
     public void iniciar() {
            getVentanaPrincipal().setSize(800, 600);
            getVentanaPrincipal().setVisible(true);
            
            System.out.println("Iniciando hilo 1");
            getVentanaPrincipal().getListClients().setModel(listaCombo);
            getMiSistema().start();
            System.out.println("Finalizando!");
                      
      }
     
     public void ActualizarVentana(Object o){
         
         for (Thread item : getMiSistema().getListaTareas()){
              Hilo hilo = (Hilo) item;
              
              if(hilo.getCliente().getId()== Integer.valueOf(o.toString()) )
              {
                getVentanaPrincipal().getBrokenGG1().setText(String.valueOf(hilo.getCliente().getCantVerde1()));
                getVentanaPrincipal().getBrokenGG2().setText(String.valueOf(hilo.getCliente().getCantVerde2()));
                getVentanaPrincipal().getBrokenRG1().setText(String.valueOf(hilo.getCliente().getCantRojo1()));
                getVentanaPrincipal().getBrokenRG2().setText(String.valueOf(hilo.getCliente().getCantRojo2()));
                getVentanaPrincipal().getBrokenYG1().setText(String.valueOf(hilo.getCliente().getCantAmarillo1()));
                getVentanaPrincipal().getBrokenYG2().setText(String.valueOf(hilo.getCliente().getCantAmarillo2()));
              }
         }
     }
    
    public Vista getVentanaPrincipal() {
            if (ventanaPrincipal == null) {
                  ventanaPrincipal = new Vista(this);
            }
            return ventanaPrincipal;
      }
}
