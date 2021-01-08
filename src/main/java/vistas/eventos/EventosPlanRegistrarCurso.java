package vistas.eventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import modelos.Curso;
import vistas.componentes.ComponentesPlanRegistrarCurso;
import vistas.componentes.ComponentesPlanRegistrarMateria;
import vistas.ventanas.VentanaContainer;

public class EventosPlanRegistrarCurso extends MouseAdapter {

  public EventosPlanRegistrarCurso() {

  }

  public void mouseClicked(MouseEvent mouseEvent) {
    int column = ComponentesPlanRegistrarCurso
      .table
      .getColumnModel()
      .getColumnIndexAtX(mouseEvent.getX());
    int row = mouseEvent
      .getY()/ComponentesPlanRegistrarCurso.table.getRowHeight();
    Object value = ComponentesPlanRegistrarCurso.table.getValueAt(row, column);
    if(value instanceof JButton) {
      JButton button = (JButton) value;
      String nombreBoton = button.getName();
      if(nombreBoton.equals("seleccionar")){
        this.seleccionar(row);
      }
    }
  }

  private void seleccionar(int row){
    Curso curso = new Curso();
    curso.id = (int) ComponentesPlanRegistrarCurso.table.getValueAt(row, 0);
    curso.nombre = (String) ComponentesPlanRegistrarCurso.table.getValueAt(row, 1);
    EventosPlanRegistrarMateria.setCurso(curso);
    VentanaContainer.getInstancia().cerrarVentanas();
    ComponentesPlanRegistrarMateria.actualizarTabla();
    VentanaContainer.getInstancia().ventanaPlanRegistrarMateria.frame.setVisible(true);
  }
}
