package vistas.eventos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import vistas.ventanas.VentanaContainer;
import vistas.componentes.ComponentesCursosRegistrar;
import vistas.componentes.ComponentesCursosMostrar;
import vistas.componentes.ComponentesEstudiantesMostrar;
import vistas.componentes.ComponentesEstudiantesRegistrar;
import vistas.componentes.ComponentesInscripcionRegistrarCurso;
import vistas.componentes.ComponentesInscripcionMostrarCurso;
import vistas.componentes.ComponentesMateriasMostrar;
import vistas.componentes.ComponentesMateriasRegistrar;
import vistas.componentes.ComponentesNotasRegistrarCurso;
import vistas.componentes.ComponentesPlanRegistrarCurso;
import vistas.componentes.ComponentesReporteNotasCursoCurso;
import vistas.componentes.ComponentesReporteNotasEstudianteEstudiante;
import vistas.componentes.ComponentesPlanMostrarCurso;
import vistas.componentes.ComponentesUsuariosMostrar;
import vistas.componentes.ComponentesUsuariosRegistrar;

/**
* Class.
*/
public class EventosNavegar implements ActionListener {

  /**
  * Constructor.
  */
  public EventosNavegar() {
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    VentanaContainer.getInstancia().cerrarVentanas();
    EventosUsuariosRegistrar.editar = false;
    switch (actionEvent.getActionCommand()) {
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
      case "Plan Mostrar":
        ComponentesPlanMostrarCurso.actualizarTabla();
        VentanaContainer.getInstancia().ventanaPlanMostrarCurso.frame.setVisible(true);
        break;
      case "Inscripciones Registrar":
        ComponentesInscripcionRegistrarCurso.actualizarTabla();
        VentanaContainer.getInstancia().ventanaInscripcionRegistrarCurso.frame.setVisible(true);
        break;
      case "Inscripciones Mostrar":
        ComponentesInscripcionMostrarCurso.actualizarTabla();
        VentanaContainer.getInstancia().ventanaInscripcionMostrarCurso.frame.setVisible(true);
        break;
      case "Notas Registrar y Mostrar":
        ComponentesNotasRegistrarCurso.actualizarTabla();
        VentanaContainer.getInstancia().ventanaNotasRegistrarCurso.frame.setVisible(true);
        break;
      case "Reporte Notas Por Curso":
        ComponentesReporteNotasCursoCurso.actualizarTabla();
        VentanaContainer.getInstancia().ventanaReporteNotasCursoCurso.frame.setVisible(true);
        break;
      case "Reporte Notas Por Estudiante":
        ComponentesReporteNotasEstudianteEstudiante.actualizarTabla();
        VentanaContainer.getInstancia().ventanaReporteNotasEstudianteEstudiante.frame.setVisible(true);
        break;
      default:
        // code block
    }
  }
}
