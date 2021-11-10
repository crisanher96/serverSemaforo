
package presentacion;

import java.io.IOException;
import logica.Conexion;

public class Modelo {
    
    private Vista ventanaPrincipal;
    
    private Conexion conexion;

    public Conexion getMiSistema() {
        if(conexion == null){
            conexion = new Conexion();
        }
        return conexion;
    }
    
    
     public void iniciar() {
            getVentanaPrincipal().setSize(800, 600);
            getVentanaPrincipal().setVisible(true);
            
            try {
                System.out.println("Estableciendo conexión...");
                getMiSistema().conectar();
                System.out.println("Finalizando!");
            } catch (IOException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
                      
      }
    
    public Vista getVentanaPrincipal() {
            if (ventanaPrincipal == null) {
                  ventanaPrincipal = new Vista(this);
            }
            return ventanaPrincipal;
      }
}
