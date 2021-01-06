package vistas.eventos;

import datos.ConexionDelete;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import vistas.componentes.ComponentesMateriasMostrar;
import vistas.componentes.ComponentesMateriasRegistrar;
import vistas.ventanas.VentanaContainer;

import javax.swing.JOptionPane;

public class EventosMateriasMostrar extends MouseAdapter {

  public EventosMateriasMostrar() {

  }

  public void mouseClicked(MouseEvent mouseEvent) {
    int column = ComponentesMateriasMostrar
      .table
      .getColumnModel()
      .getColumnIndexAtX(mouseEvent.getX());
    int row = mouseEvent
      .getY()/ComponentesMateriasMostrar.table.getRowHeight();
    Object value = ComponentesMateriasMostrar.table.getValueAt(row, column);
    if(value instanceof JButton){
      JButton button = (JButton) value;
      String nombreBoton = button.getName();
      if(nombreBoton == "Editar"){
        this.editar(row);
      } else if(nombreBoton == "Eliminar") {
        this.eliminar(row);
      }
    }
  }

  private void editar(int row){
    // Obtener valores de la tabla
    int id = (int) ComponentesMateriasMostrar.table.getValueAt(row, 0);
    String nombre = (String) ComponentesMateriasMostrar.table.getValueAt(row, 1);

    // Set valores a los componenentes del modal.
    ComponentesMateriasRegistrar.fieldNombre.setText(nombre);
    
    // Abrir usuarios modal.
    EventosMateriasRegistrar.editar = true;
    EventosMateriasRegistrar.id = id;
    VentanaContainer.getInstancia().cerrarVentanas();
    VentanaContainer.getInstancia().ventanaMateriasRegistrar.frame.setVisible(true);
  }

  private void eliminar(int row) {
    int id = (int) ComponentesMateriasMostrar.table.getValueAt(row, 0);
    // Si = 0, No = 1
    String mensaje = "Realmente desea realizar esta accion";
    int result = JOptionPane.showConfirmDialog(null, mensaje, "Confirmacion",
       JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if(result == 0) {
      ConexionDelete.execute("subjects", id);
      ComponentesMateriasMostrar.actualizarTabla();
    }
  }
}
