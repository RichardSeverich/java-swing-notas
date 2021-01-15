package vistas.eventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import modelos.Estudiante;
import vistas.componentes.ComponentesNotasRegistrarEstudiante;
import vistas.componentes.ComponentesNotasRegistrarMateria;
import vistas.ventanas.VentanaContainer;

/**
* Class.
*/
public class EventosNotasRegistrarEstudiante extends MouseAdapter {

  /**
  * Constructor.
  */
  public EventosNotasRegistrarEstudiante() {
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
    int column = ComponentesNotasRegistrarEstudiante
        .table
        .getColumnModel()
        .getColumnIndexAtX(mouseEvent.getX());
    int row = mouseEvent
        .getY() / ComponentesNotasRegistrarEstudiante.table.getRowHeight();
    Object value = ComponentesNotasRegistrarEstudiante.table.getValueAt(row, column);
    if (value instanceof JButton) {
      JButton button = (JButton) value;
      String nombreBoton = button.getName();
      if (nombreBoton.equals("seleccionar")) {
        this.seleccionar(row);
      }
    }
  }

  /**
   * @param row row.
  */
  private void seleccionar(int row) {
    Estudiante estudiante = new Estudiante();
    estudiante.id = (int) ComponentesNotasRegistrarEstudiante.table.getValueAt(row, 0);
    estudiante.dni = (String) ComponentesNotasRegistrarEstudiante.table.getValueAt(row, 1);
    estudiante.nombres = (String) ComponentesNotasRegistrarEstudiante.table.getValueAt(row, 2);
    estudiante.apellidos = (String) ComponentesNotasRegistrarEstudiante.table.getValueAt(row, 3);
    EventosNotasRegistrarMateria.estudiante = estudiante;
    VentanaContainer.getInstancia().cerrarVentanas();
    ComponentesNotasRegistrarMateria.actualizarTabla();
    VentanaContainer.getInstancia().ventanaNotasRegistrarMateria.frame.setVisible(true);
  }
}
