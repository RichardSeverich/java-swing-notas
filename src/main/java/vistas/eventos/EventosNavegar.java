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
      case "Usuarios Registrar":
        VentanaContainer.getInstancia().VentanaUsuariosRegistrar.frame.setVisible(true);
        break;
      case "Usuarios Mostrar":
        // code block
        break;
      case "Estudiantes Registrar":
        // code block
        break;
      case "Estudiantes Mostrar":
        // code block
        break;
      case "Cursos Registrar":
        // code block
        break;
      case "Cursos Mostrar":
        // code block
        break;
      default:
        // code block
    }
  }
}
