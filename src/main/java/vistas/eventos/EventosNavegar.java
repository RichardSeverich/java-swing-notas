package vistas.eventos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import vistas.ventanas.VentanaContainer;

public class EventosNavegar implements ActionListener {

  public EventosNavegar() {

  }

  public void actionPerformed(ActionEvent actionEvent) {
    VentanaContainer.getInstancia().cerrarVentanas();
    switch(actionEvent.getActionCommand()) {
      case "Usuario Registrar":
        VentanaContainer.getInstancia().VentanaUsuariosRegistrar.frame.setVisible(true);
        break;
      case "Usuario Mostrar":
        // code block
        break;
      default:
        // code block
    }
  }
}
