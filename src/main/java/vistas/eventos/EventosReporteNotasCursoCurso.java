package vistas.eventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import modelos.Curso;
import vistas.componentes.ComponentesReporteNotasCursoCurso;
import vistas.componentes.ComponentesReporteNotasCursoEstudiante;
import vistas.ventanas.VentanaContainer;

/**
* Class.
*/
public class EventosReporteNotasCursoCurso extends MouseAdapter {

  /**
  * Constructor.
  */
  public EventosReporteNotasCursoCurso() {
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
    int column = ComponentesReporteNotasCursoCurso
        .table
        .getColumnModel()
        .getColumnIndexAtX(mouseEvent.getX());
    int row = mouseEvent
        .getY() / ComponentesReporteNotasCursoCurso.table.getRowHeight();
    Object value = ComponentesReporteNotasCursoCurso.table.getValueAt(row, column);
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
    curso.id = (int) ComponentesReporteNotasCursoCurso.table.getValueAt(row, 0);
    curso.nombre = (String) ComponentesReporteNotasCursoCurso.table.getValueAt(row, 1);
    ComponentesReporteNotasCursoEstudiante.course = curso;
    VentanaContainer.getInstancia().cerrarVentanas();
    ComponentesReporteNotasCursoEstudiante.actualizarTabla();
    VentanaContainer.getInstancia().ventanaReporteNotasCursoEstudiante.frame.setVisible(true);
  }
}
