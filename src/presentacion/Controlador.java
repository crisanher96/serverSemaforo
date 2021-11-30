
package presentacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import presentacion.Modelo;

public class Controlador implements MouseListener,ActionListener, ComponentListener, ChangeListener, FocusListener {
    private final Vista ventanaPrincipal;
    private final Modelo modelo;    
    
    public Controlador(Vista ventana) {
        this.ventanaPrincipal = ventana;
        modelo = ventana.getModelo();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() instanceof JButton){
            JButton boton = (JButton) e.getSource();            

            if (boton == ventanaPrincipal.getButtonLoad() || boton == ventanaPrincipal.getButtonUpdate()) {
                
                    getModelo().ActualizarVentana(ventanaPrincipal.getListClients().getSelectedItem());
                
                
            } 
        }
         
        if(e.getSource() instanceof JRadioButton){
            JRadioButton Rboton = (JRadioButton) e.getSource();
            
            if (Rboton == ventanaPrincipal.getCheckGG1()) {
                ventanaPrincipal.setCheckGG1();
            }
            if (Rboton == ventanaPrincipal.getCheckGG2()) {
                ventanaPrincipal.setCheckGG2();
            }
            if (Rboton == ventanaPrincipal.getCheckRG1()) {
                ventanaPrincipal.setCheckRG1();
            }
            if (Rboton == ventanaPrincipal.getCheckRG2()) {
                ventanaPrincipal.setCheckRG2();
            }
            if (Rboton == ventanaPrincipal.getCheckYG1()) {
                ventanaPrincipal.setCheckYG1();
            }
            if (Rboton == ventanaPrincipal.getCheckYG2()) {
                ventanaPrincipal.setCheckYG2();
            }
            
        }
    
    }

    @Override
    public void componentResized(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentShown(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusGained(FocusEvent e) {
        modelo.setListaClientes();
    }

    @Override
    public void focusLost(FocusEvent e) {
        
    }
    
    public Modelo getModelo() {
        return modelo;
    }
}
