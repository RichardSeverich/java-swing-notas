package vistas.eventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import modelos.Curso;
import vistas.componentes.ComponentesReporteNotasEstudianteCurso;
import vistas.componentes.ComponentesReporteNotasEstudianteMateria;
import vistas.ventanas.VentanaContainer;

/**
* Class.
*/
public class EventosReporteNotasEstudianteCurso extends MouseAdapter {
  public static Curso curso;

  /**
  * Constructor.
  */
  public EventosReporteNotasEstudianteCurso() {
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
    int column = ComponentesReporteNotasEstudianteCurso
        .table
        .getColumnModel()
        .getColumnIndexAtX(mouseEvent.getX());
    int row = mouseEvent
        .getY() / ComponentesReporteNotasEstudianteCurso.table.getRowHeight();
    Object value = ComponentesReporteNotasEstudianteCurso.table.getValueAt(row, column);
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
    curso.id = (int) ComponentesReporteNotasEstudianteCurso.table.getValueAt(row, 0);
    curso.nombre = (String) ComponentesReporteNotasEstudianteCurso.table.getValueAt(row, 1);
    EventosReporteNotasEstudianteCurso.curso = curso;
    VentanaContainer.getInstancia().cerrarVentanas();
    ComponentesReporteNotasEstudianteMateria.actualizarTabla();
    VentanaContainer.getInstancia().ventanaReporteNotasEstudianteMateria.frame.setVisible(true);
  }
}
