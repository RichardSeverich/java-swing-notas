package vistas.eventos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import vistas.ventanas.VentanaContainer;
import vistas.componentes.ComponentesUsuariosMostrar;
import vistas.componentes.ComponentesUsuariosRegistrar;

public class EventosNavegar implements ActionListener {

  public EventosNavegar() {

  }

  public void actionPerformed(ActionEvent actionEvent) {
    VentanaContainer.getInstancia().cerrarVentanas();
    EventosUsuariosRegistrar.editar = false;
    switch(actionEvent.getActionCommand()) {
      case "Usuarios Registrar":
        ComponentesUsuariosRegistrar.limpiar();
        VentanaContainer.getInstancia().ventanaUsuariosRegistrar.frame.setVisible(true);
        break;
      case "Usuarios Mostrar":
        ComponentesUsuariosMostrar.actualizarTabla();
        VentanaContainer.getInstancia().ventanaUsuariosMostrar.frame.setVisible(true);
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
