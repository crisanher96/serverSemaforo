
package presentacion;

import java.io.IOException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import logica.Conexion;

public class Modelo {
    
    DefaultComboBoxModel<String> listaCombo = new DefaultComboBoxModel<>();
    private Vista ventanaPrincipal;
    
    private Conexion conexion;

    public Conexion getMiSistema() {
        if(conexion == null){
            conexion = new Conexion();
        }
        return conexion;
    }
    
    public void setListaClientes(){
        listaCombo.removeAllElements();
        List<String> listaClientes = getMiSistema().getListaClientes();
        for(String item:listaClientes ){
            listaCombo.addElement(item);
        }
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
         
         getVentanaPrincipal().getBrokenGG1().setText("0");
         getVentanaPrincipal().getBrokenGG2().setText("0");
         getVentanaPrincipal().getBrokenRG1().setText("0");
         getVentanaPrincipal().getBrokenRG2().setText("0");
         getVentanaPrincipal().getBrokenYG1().setText("0");
         getVentanaPrincipal().getBrokenYG2().setText("0");
     }
    
    public Vista getVentanaPrincipal() {
            if (ventanaPrincipal == null) {
                  ventanaPrincipal = new Vista(this);
            }
            return ventanaPrincipal;
      }
}
