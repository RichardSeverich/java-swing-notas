package vistas.eventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import modelos.Curso;
import vistas.componentes.ComponentesPlanMostrarCurso;
import vistas.componentes.ComponentesPlanMostrarMateria;
import vistas.ventanas.VentanaContainer;

/**
* Class.
*/
public class EventosPlanMostrarCurso extends MouseAdapter {

  /**
  * Constructor.
  */
  public EventosPlanMostrarCurso() {
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
    int column = ComponentesPlanMostrarCurso
        .table
        .getColumnModel()
        .getColumnIndexAtX(mouseEvent.getX());
    int row = mouseEvent
        .getY() / ComponentesPlanMostrarCurso.table.getRowHeight();
    Object value = ComponentesPlanMostrarCurso.table.getValueAt(row, column);
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
    curso.id = (int) ComponentesPlanMostrarCurso.table.getValueAt(row, 0);
    curso.nombre = (String) ComponentesPlanMostrarCurso.table.getValueAt(row, 1);
    EventosPlanRegistrarMateria.setCurso(curso);
    ComponentesPlanMostrarMateria.course = curso;
    VentanaContainer.getInstancia().cerrarVentanas();
    ComponentesPlanMostrarMateria.actualizarTabla();
    VentanaContainer.getInstancia().ventanaPlanMostrarMateria.frame.setVisible(true);
  }
}
