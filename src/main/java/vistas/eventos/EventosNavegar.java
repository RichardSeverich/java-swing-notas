package vistas.eventos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import vistas.ventanas.VentanaContainer;
import vistas.componentes.ComponentesCursosRegistrar;
import vistas.componentes.ComponentesCursosMostrar;
import vistas.componentes.ComponentesEstudiantesMostrar;
import vistas.componentes.ComponentesEstudiantesRegistrar;
import vistas.componentes.ComponentesMateriasMostrar;
import vistas.componentes.ComponentesMateriasRegistrar;
import vistas.componentes.ComponentesPlanRegistrarCurso;
import vistas.componentes.ComponentesPlanRegistrarMateria;
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
        ComponentesEstudiantesRegistrar.limpiar();
        VentanaContainer.getInstancia().ventanaEstudiantesRegistrar.frame.setVisible(true);
        break;
      case "Estudiantes Mostrar":
        ComponentesEstudiantesMostrar.actualizarTabla();
        VentanaContainer.getInstancia().ventanaEstudiantesMostrar.frame.setVisible(true);
        break;
      case "Cursos Registrar":
        ComponentesCursosRegistrar.limpiar();
        VentanaContainer.getInstancia().ventanaCursosRegistrar.frame.setVisible(true);
        break;
      case "Cursos Mostrar":
        ComponentesCursosMostrar.actualizarTabla();
        VentanaContainer.getInstancia().ventanaCursosMostrar.frame.setVisible(true);
        break;
      case "Materias Registrar":
        ComponentesMateriasRegistrar.limpiar();
        VentanaContainer.getInstancia().ventanaMateriasRegistrar.frame.setVisible(true);
        break;
      case "Materias Mostrar":
        ComponentesMateriasMostrar.actualizarTabla();
        VentanaContainer.getInstancia().ventanaMateriasMostrar.frame.setVisible(true);
        break;
      case "Plan Registrar":
        ComponentesPlanRegistrarCurso.actualizarTabla();
        VentanaContainer.getInstancia().ventanaPlanRegistrarCurso.frame.setVisible(true);
        break;
      default:
        // code block
    }
  }
}
