package vistas.eventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import datos.ConexionDelete;
import modelos.Curso;
import vistas.componentes.ComponentesPlanMostrarMateria;

/**
* Class.
*/
public class EventosPlanMostrarMateria extends MouseAdapter {
  protected static Curso curso;

  /**
  * Constructor.
  */
  public EventosPlanMostrarMateria() {
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
    int column = ComponentesPlanMostrarMateria
        .table
        .getColumnModel()
        .getColumnIndexAtX(mouseEvent.getX());
    int row = mouseEvent
        .getY() / ComponentesPlanMostrarMateria.table.getRowHeight();
    Object value = ComponentesPlanMostrarMateria.table.getValueAt(row, column);
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
    EventosPlanRegistrarMateria.curso = curso;
  }

  /**
   * @param row row.
  */
  private void eliminar(int row) {
    int id = (int) ComponentesPlanMostrarMateria.table.getValueAt(row, 0);
    String nombreMateria = (String) ComponentesPlanMostrarMateria.table.getValueAt(row, 1);
    String mensaje = "Eliminar a " + nombreMateria + "?";
    int result = JOptionPane.showConfirmDialog(null, mensaje, "Eliminar",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (result == 0) {
      ConexionDelete.execute("courses_subjects", id);
      ComponentesPlanMostrarMateria.actualizarTabla();
      JOptionPane.showMessageDialog(null, "se elimino a " + nombreMateria);
    }
  }
}
