package vistas.eventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import modelos.Curso;
import vistas.componentes.ComponentesNotasRegistrarCurso;
import vistas.componentes.ComponentesNotasRegistrarEstudiante;
import vistas.ventanas.VentanaContainer;

/**
* Class.
*/
public class EventosNotasRegistrarCurso extends MouseAdapter {

  /**
  * Constructor.
  */
  public EventosNotasRegistrarCurso() {
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
    int column = ComponentesNotasRegistrarCurso
        .table
        .getColumnModel()
        .getColumnIndexAtX(mouseEvent.getX());
    int row = mouseEvent
        .getY() / ComponentesNotasRegistrarCurso.table.getRowHeight();
    Object value = ComponentesNotasRegistrarCurso.table.getValueAt(row, column);
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
    Curso curso = new Curso();
    curso.id = (int) ComponentesNotasRegistrarCurso.table.getValueAt(row, 0);
    curso.nombre = (String) ComponentesNotasRegistrarCurso.table.getValueAt(row, 1);
    ComponentesNotasRegistrarEstudiante.course = curso;
    VentanaContainer.getInstancia().cerrarVentanas();
    ComponentesNotasRegistrarEstudiante.actualizarTabla();
    VentanaContainer.getInstancia().ventanaNotasRegistrarEstudiante.frame.setVisible(true);
  }
}
