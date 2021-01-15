package vistas.eventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import datos.ConexionInsertSubjectsStudents;
import modelos.Estudiante;
import modelos.Materia;
import vistas.componentes.ComponentesNotasRegistrarMateria;

/**
* Class.
*/
public class EventosNotasRegistrarMateria extends MouseAdapter {
  public static Estudiante estudiante;

  /**
  * Constructor.
  */
  public EventosNotasRegistrarMateria() {
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
    int column = ComponentesNotasRegistrarMateria
        .table
        .getColumnModel()
        .getColumnIndexAtX(mouseEvent.getX());
    int row = mouseEvent
        .getY() / ComponentesNotasRegistrarMateria.table.getRowHeight();
    Object value = ComponentesNotasRegistrarMateria.table.getValueAt(row, column);
    if (value instanceof JButton) {
      JButton button = (JButton) value;
      String nombreBoton = button.getName();
      if (nombreBoton.equals("calificar")) {
        this.calificar(row);
      }
    }
  }

  /**
   * @param row row.
  */
  private void calificar(int row) {
    Materia materia = new Materia();
    materia.id = (int) ComponentesNotasRegistrarMateria.table.getValueAt(row, 1);
    materia.nombre = (String) ComponentesNotasRegistrarMateria.table.getValueAt(row, 2);
    String nota = JOptionPane.showInputDialog("Ingresar nota");
    if (nota != null) {
      ConexionInsertSubjectsStudents.execute(materia, estudiante, nota);
      ComponentesNotasRegistrarMateria.actualizarTabla();
      JOptionPane.showMessageDialog(null, "Materia " + materia.nombre + " nota " + nota);
    }
  }
}
