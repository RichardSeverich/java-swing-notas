package vistas.eventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import modelos.Curso;
import vistas.componentes.ComponentesInscripcionRegistrarCurso;
import vistas.componentes.ComponentesInscripcionRegistrarEstudiante;
import vistas.ventanas.VentanaContainer;

/**
* Class.
*/
public class EventosInscripcionRegistrarCurso extends MouseAdapter {

  /**
  * Constructor.
  */
  public EventosInscripcionRegistrarCurso() {
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
    int column = ComponentesInscripcionRegistrarCurso
        .table
        .getColumnModel()
        .getColumnIndexAtX(mouseEvent.getX());
    int row = mouseEvent
        .getY() / ComponentesInscripcionRegistrarCurso.table.getRowHeight();
    Object value = ComponentesInscripcionRegistrarCurso.table.getValueAt(row, column);
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
    curso.id = (int) ComponentesInscripcionRegistrarCurso.table.getValueAt(row, 0);
    curso.nombre = (String) ComponentesInscripcionRegistrarCurso.table.getValueAt(row, 1);
    EventosInscripcionRegistrarEstudiante.setCurso(curso);
    ComponentesInscripcionRegistrarEstudiante.course = curso;
    VentanaContainer.getInstancia().cerrarVentanas();
    ComponentesInscripcionRegistrarEstudiante.actualizarTabla();
    VentanaContainer.getInstancia().ventanaInscripcionRegistrarEstudiante.frame.setVisible(true);
  }
}
