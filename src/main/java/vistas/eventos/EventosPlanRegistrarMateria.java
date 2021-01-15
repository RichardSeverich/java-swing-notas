package vistas.eventos;

import static javax.swing.JOptionPane.showMessageDialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import datos.ConexionInsertCursosSubjects;
import modelos.Curso;
import modelos.Materia;
import vistas.componentes.ComponentesPlanRegistrarMateria;

/**
* Class.
*/
public class EventosPlanRegistrarMateria extends MouseAdapter {
  protected static Curso curso;

  /**
  * Constructor.
  */
  public EventosPlanRegistrarMateria() {
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
    int column = ComponentesPlanRegistrarMateria
        .table
        .getColumnModel()
        .getColumnIndexAtX(mouseEvent.getX());
    int row = mouseEvent
        .getY() / ComponentesPlanRegistrarMateria.table.getRowHeight();
    Object value = ComponentesPlanRegistrarMateria.table.getValueAt(row, column);
    if (value instanceof JButton) {
      JButton button = (JButton) value;
      String nombreBoton = button.getName();
      if (nombreBoton.equals("agregar")) {
        this.agregar(row);
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
  private void agregar(int row) {
    Materia materia = new Materia();
    materia.id = (int) ComponentesPlanRegistrarMateria.table.getValueAt(row, 0);
    materia.nombre = (String) ComponentesPlanRegistrarMateria.table.getValueAt(row, 1);
    ConexionInsertCursosSubjects.execute(curso, materia);
    ComponentesPlanRegistrarMateria.actualizarTabla();
    showMessageDialog(null, "agrego la materia " + materia.nombre + " exitosamente");
  }
}
