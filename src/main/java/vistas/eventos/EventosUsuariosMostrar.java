package vistas.eventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import static javax.swing.JOptionPane.showMessageDialog;

import vistas.validadores.ValidadorUsuarios;
import vistas.componentes.ComponentesUsuariosMostrar;

public class EventosUsuariosMostrar extends MouseAdapter {

  public EventosUsuariosMostrar() {

  }

  public void mouseClicked(MouseEvent mouseEvent) {
    int column = ComponentesUsuariosMostrar
      .table
      .getColumnModel()
      .getColumnIndexAtX(mouseEvent.getX());
    int row = mouseEvent
      .getY()/ComponentesUsuariosMostrar.table.getRowHeight();
    Object value = ComponentesUsuariosMostrar.table.getValueAt(row, column);
    if(value instanceof JButton){
      ((JButton)value).doClick();
      JButton button = (JButton) value;
      String name = button.getName();
      System.out.println(name);
    }
  }

}
