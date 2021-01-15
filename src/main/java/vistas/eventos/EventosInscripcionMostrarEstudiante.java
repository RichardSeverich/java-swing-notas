package vistas.eventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import datos.ConexionDelete;
import modelos.Curso;
import vistas.componentes.ComponentesInscripcionMostrarEstudiante;

/**
* Class.
*/
public class EventosInscripcionMostrarEstudiante extends MouseAdapter {
  protected static Curso curso;

  /**
  * Constructor.
  */
  public EventosInscripcionMostrarEstudiante() {
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
    int column = ComponentesInscripcionMostrarEstudiante
        .table
        .getColumnModel()
        .getColumnIndexAtX(mouseEvent.getX());
    int row = mouseEvent
        .getY() / ComponentesInscripcionMostrarEstudiante.table.getRowHeight();
    Object value = ComponentesInscripcionMostrarEstudiante.table.getValueAt(row, column);
    if (value instanceof JButton) {
      JButton button = (JButton) value;
      String nombreBoton = button.getName();
      if (nombreBoton.equals("eliminar")) {
        this.eliminar(row);
      }
    }
  }

  /**
   * @param curso curso.
  */
  public static void setCurso(Curso curso) {
    EventosInscripcionMostrarEstudiante.curso = curso;
  }

  /**
   * @param row row.
  */
  private void eliminar(int row) {
    int idRelacion = (int) ComponentesInscripcionMostrarEstudiante.table.getValueAt(row, 0);
    String nombreEstudiante = (String) ComponentesInscripcionMostrarEstudiante.table.getValueAt(row, 3);
    String apellidosEstudiante = (String) ComponentesInscripcionMostrarEstudiante.table.getValueAt(row, 4);
    String mensaje = "Eliminar al estudiante " + nombreEstudiante + " " + apellidosEstudiante + "?";
    int result = JOptionPane.showConfirmDialog(null, mensaje, "Eliminar",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (result == 0) {
      ConexionDelete.execute("courses_students", idRelacion);
      ComponentesInscripcionMostrarEstudiante.actualizarTabla();
      JOptionPane.showMessageDialog(null, "se elimino a " + nombreEstudiante + " " + apellidosEstudiante);
    }
  }
}
