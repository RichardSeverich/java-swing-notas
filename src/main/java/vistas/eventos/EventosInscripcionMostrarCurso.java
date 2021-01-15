package vistas.eventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import modelos.Curso;
import vistas.componentes.ComponentesInscripcionMostrarCurso;
import vistas.componentes.ComponentesInscripcionMostrarEstudiante;
import vistas.ventanas.VentanaContainer;

/**
* Class.
*/
public class EventosInscripcionMostrarCurso extends MouseAdapter {

  /**
  * Constructor.
  */
  public EventosInscripcionMostrarCurso() {
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
    int column = ComponentesInscripcionMostrarCurso
        .table
        .getColumnModel()
        .getColumnIndexAtX(mouseEvent.getX());
    int row = mouseEvent
        .getY() / ComponentesInscripcionMostrarCurso.table.getRowHeight();
    Object value = ComponentesInscripcionMostrarCurso.table.getValueAt(row, column);
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
    curso.id = (int) ComponentesInscripcionMostrarCurso.table.getValueAt(row, 0);
    curso.nombre = (String) ComponentesInscripcionMostrarCurso.table.getValueAt(row, 1);
    EventosInscripcionRegistrarEstudiante.setCurso(curso);
    ComponentesInscripcionMostrarEstudiante.course = curso;
    VentanaContainer.getInstancia().cerrarVentanas();
    ComponentesInscripcionMostrarEstudiante.actualizarTabla();
    VentanaContainer.getInstancia().ventanaInscripcionMostrarEstudiante.frame.setVisible(true);
  }
}
