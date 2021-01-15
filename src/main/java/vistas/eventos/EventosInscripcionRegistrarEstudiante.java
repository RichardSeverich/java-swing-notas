package vistas.eventos;

import static javax.swing.JOptionPane.showMessageDialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import datos.ConexionInsertCursosStudents;
import modelos.Curso;
import modelos.Estudiante;
import vistas.componentes.ComponentesInscripcionRegistrarEstudiante;

/**
* Class.
*/
public class EventosInscripcionRegistrarEstudiante extends MouseAdapter {
  protected static Curso curso;

  /**
  * Constructor.
  */
  public EventosInscripcionRegistrarEstudiante() {
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
    int column = ComponentesInscripcionRegistrarEstudiante
        .table
        .getColumnModel()
        .getColumnIndexAtX(mouseEvent.getX());
    int row = mouseEvent
        .getY() / ComponentesInscripcionRegistrarEstudiante.table.getRowHeight();
    Object value = ComponentesInscripcionRegistrarEstudiante.table.getValueAt(row, column);
    if (value instanceof JButton) {
      JButton button = (JButton) value;
      String nombreBoton = button.getName();
      if (nombreBoton.equals("inscribir")) {
        this.inscribir(row);
      }
    }
  }

  /**
   * @param curso curso.
  */
  public static void setCurso(Curso curso) {
    EventosInscripcionRegistrarEstudiante.curso = curso;
  }

  /**
   * @param row row.
  */
  private void inscribir(int row) {
    Estudiante estudiante = new Estudiante();
    estudiante.id = (int) ComponentesInscripcionRegistrarEstudiante.table.getValueAt(row, 0);
    estudiante.dni = (String) ComponentesInscripcionRegistrarEstudiante.table.getValueAt(row, 1);
    estudiante.nombres = (String) ComponentesInscripcionRegistrarEstudiante.table.getValueAt(row, 2);
    estudiante.apellidos = (String) ComponentesInscripcionRegistrarEstudiante.table.getValueAt(row, 3);
    ConexionInsertCursosStudents.execute(curso, estudiante);
    ComponentesInscripcionRegistrarEstudiante.actualizarTabla();
    showMessageDialog(null, "inscribiste a " + estudiante.nombres + " " + estudiante.apellidos);
  }
}
