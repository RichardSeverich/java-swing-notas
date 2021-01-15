package vistas.eventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import modelos.Estudiante;
import vistas.componentes.ComponentesReporteNotasEstudianteEstudiante;
import vistas.componentes.ComponentesReporteNotasEstudianteCurso;
import vistas.ventanas.VentanaContainer;

/**
* Class.
*/
public class EventosReporteNotasEstudianteEstudiante extends MouseAdapter {
  public static Estudiante estudiante;

  /**
  * Constructor.
  */
  public EventosReporteNotasEstudianteEstudiante() {
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
    int column = ComponentesReporteNotasEstudianteEstudiante
        .table
        .getColumnModel()
        .getColumnIndexAtX(mouseEvent.getX());
    int row = mouseEvent
        .getY() / ComponentesReporteNotasEstudianteEstudiante.table.getRowHeight();
    Object value = ComponentesReporteNotasEstudianteEstudiante.table.getValueAt(row, column);
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
    estudiante.id = (int) ComponentesReporteNotasEstudianteEstudiante.table.getValueAt(row, 0);
    estudiante.dni = (String) ComponentesReporteNotasEstudianteEstudiante.table.getValueAt(row, 1);
    estudiante.nombres = (String) ComponentesReporteNotasEstudianteEstudiante.table.getValueAt(row, 2);
    estudiante.apellidos = (String) ComponentesReporteNotasEstudianteEstudiante.table.getValueAt(row, 3);
    EventosReporteNotasEstudianteEstudiante.estudiante = estudiante;
    VentanaContainer.getInstancia().cerrarVentanas();
    ComponentesReporteNotasEstudianteCurso.actualizarTabla();
    VentanaContainer.getInstancia().ventanaReporteNotasEstudianteCurso.frame.setVisible(true);
  }
}
