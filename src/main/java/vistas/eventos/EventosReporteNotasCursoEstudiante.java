package vistas.eventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import modelos.Estudiante;
import vistas.componentes.ComponentesReporteNotasCursoEstudiante;
import vistas.componentes.ComponentesReporteNotasCursoMateria;
import vistas.ventanas.VentanaContainer;

/**
* Class.
*/
public class EventosReporteNotasCursoEstudiante extends MouseAdapter {
  public static Estudiante estudiante;

  /**
  * Constructor.
  */
  public EventosReporteNotasCursoEstudiante() {
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
    int column = ComponentesReporteNotasCursoEstudiante
        .table
        .getColumnModel()
        .getColumnIndexAtX(mouseEvent.getX());
    int row = mouseEvent
        .getY() / ComponentesReporteNotasCursoEstudiante.table.getRowHeight();
    Object value = ComponentesReporteNotasCursoEstudiante.table.getValueAt(row, column);
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
    estudiante.id = (int) ComponentesReporteNotasCursoEstudiante.table.getValueAt(row, 0);
    estudiante.dni = (String) ComponentesReporteNotasCursoEstudiante.table.getValueAt(row, 1);
    estudiante.nombres = (String) ComponentesReporteNotasCursoEstudiante.table.getValueAt(row, 2);
    estudiante.apellidos = (String) ComponentesReporteNotasCursoEstudiante.table.getValueAt(row, 3);
    EventosReporteNotasCursoEstudiante.estudiante = estudiante;
    VentanaContainer.getInstancia().cerrarVentanas();
    ComponentesReporteNotasCursoMateria.actualizarTabla();
    VentanaContainer.getInstancia().ventanaReporteNotasCursoMateria.frame.setVisible(true);
  }
}
