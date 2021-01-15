package vistas.ventanas;

/**
* Class.
*/
public final class VentanaContainer {
  public static VentanaContainer ventanaContainer;
  public Ventana ventanaLogin;
  public Ventana ventanaDashboard;
  public Ventana ventanaUsuariosRegistrar;
  public Ventana ventanaUsuariosMostrar;
  public Ventana ventanaEstudiantesRegistrar;
  public Ventana ventanaEstudiantesMostrar;
  public Ventana ventanaCursosRegistrar;
  public Ventana ventanaCursosMostrar;
  public Ventana ventanaMateriasRegistrar;
  public Ventana ventanaMateriasMostrar;
  public Ventana ventanaPlanRegistrarCurso;
  public Ventana ventanaPlanRegistrarMateria;
  public Ventana ventanaPlanMostrarCurso;
  public Ventana ventanaPlanMostrarMateria;
  public Ventana ventanaInscripcionRegistrarCurso;
  public Ventana ventanaInscripcionRegistrarEstudiante;
  public Ventana ventanaInscripcionMostrarCurso;
  public Ventana ventanaInscripcionMostrarEstudiante;
  public Ventana ventanaNotasRegistrarCurso;
  public Ventana ventanaNotasRegistrarEstudiante;
  public Ventana ventanaNotasRegistrarMateria;
  public Ventana ventanaReporteNotasCursoCurso;
  public Ventana ventanaReporteNotasCursoEstudiante;
  public Ventana ventanaReporteNotasCursoMateria;
  public Ventana ventanaReporteNotasEstudianteEstudiante;
  public Ventana ventanaReporteNotasEstudianteCurso;
  public Ventana ventanaReporteNotasEstudianteMateria;

  /**
  * Constructor.
  */
  private VentanaContainer() {
    this.ventanaLogin = new VentanaLogin();
    this.ventanaDashboard = new VentanaDashboard();
    this.ventanaUsuariosRegistrar = new VentanaUsuariosRegistrar();
    this.ventanaUsuariosMostrar = new VentanaUsuariosMostrar();
    this.ventanaEstudiantesRegistrar = new VentanaEstudiantesRegistrar();
    this.ventanaEstudiantesMostrar = new VentanaEstudiantesMostrar();
    this.ventanaCursosRegistrar = new VentanaCursosRegistrar();
    this.ventanaCursosMostrar = new VentanaCursosMostrar();
    this.ventanaMateriasRegistrar = new VentanaMateriasRegistrar();
    this.ventanaMateriasMostrar = new VentanaMateriasMostrar();
    this.ventanaPlanRegistrarCurso = new VentanaPlanRegistrarCurso();
    this.ventanaPlanRegistrarMateria = new VentanaPlanRegistrarMateria();
    this.ventanaPlanMostrarCurso = new VentanaPlanMostrarCurso();
    this.ventanaPlanMostrarMateria = new VentanaPlanMostrarMateria();
    this.ventanaInscripcionRegistrarCurso = new VentanaInscripcionRegistrarCurso();
    this.ventanaInscripcionRegistrarEstudiante = new VentanaInscripcionRegistrarEstudiante();
    this.ventanaInscripcionMostrarCurso = new VentanaInscripcionMostrarCurso();
    this.ventanaInscripcionMostrarEstudiante = new VentanaInscripcionMostrarEstudiante();
    this.ventanaNotasRegistrarCurso = new VentanaNotasRegistrarCurso();
    this.ventanaNotasRegistrarEstudiante = new VentanaNotasRegistrarEstudiante();
    this.ventanaNotasRegistrarMateria = new VentanaNotasRegistrarMateria();
    this.ventanaReporteNotasCursoCurso = new VentanaReporteNotasCursoCurso();
    this.ventanaReporteNotasCursoEstudiante = new VentanaReporteNotasCursoEstudiante();
    this.ventanaReporteNotasCursoMateria = new VentanaReporteNotasCursoMateria();
    this.ventanaReporteNotasEstudianteEstudiante = new VentanaReporteNotasEstudianteEstudiante();
    this.ventanaReporteNotasEstudianteCurso = new VentanaReporteNotasEstudianteCurso();
    this.ventanaReporteNotasEstudianteMateria = new VentanaReporteNotasEstudianteMateria();
  }

  /**
  * @return ventanaContainer.
  */
  public static VentanaContainer getInstancia() {
    if (ventanaContainer == null) {
      ventanaContainer = new VentanaContainer();
    }
    return ventanaContainer;
  }

  /**
  * Method cierra todas las ventanas.
  */
  public void cerrarVentanas() {
    this.ventanaLogin.frame.setVisible(false);
    this.ventanaDashboard.frame.setVisible(false);
    this.ventanaUsuariosRegistrar.frame.setVisible(false);
    this.ventanaUsuariosMostrar.frame.setVisible(false);
    this.ventanaEstudiantesRegistrar.frame.setVisible(false);
    this.ventanaEstudiantesMostrar.frame.setVisible(false);
    this.ventanaCursosRegistrar.frame.setVisible(false);
    this.ventanaCursosMostrar.frame.setVisible(false);
    this.ventanaMateriasRegistrar.frame.setVisible(false);
    this.ventanaMateriasMostrar.frame.setVisible(false);
    this.ventanaPlanRegistrarCurso.frame.setVisible(false);
    this.ventanaPlanRegistrarMateria.frame.setVisible(false);
    this.ventanaPlanMostrarCurso.frame.setVisible(false);
    this.ventanaPlanMostrarMateria.frame.setVisible(false);
    this.ventanaInscripcionRegistrarCurso.frame.setVisible(false);
    this.ventanaInscripcionRegistrarEstudiante.frame.setVisible(false);
    this.ventanaInscripcionMostrarCurso.frame.setVisible(false);
    this.ventanaInscripcionMostrarEstudiante.frame.setVisible(false);
    this.ventanaNotasRegistrarCurso.frame.setVisible(false);
    this.ventanaNotasRegistrarEstudiante.frame.setVisible(false);
    this.ventanaNotasRegistrarMateria.frame.setVisible(false);
    this.ventanaReporteNotasCursoCurso.frame.setVisible(false);
    this.ventanaReporteNotasCursoEstudiante.frame.setVisible(false);
    this.ventanaReporteNotasCursoMateria.frame.setVisible(false);
    this.ventanaReporteNotasEstudianteEstudiante.frame.setVisible(false);
    this.ventanaReporteNotasEstudianteCurso.frame.setVisible(false);
    this.ventanaReporteNotasEstudianteMateria.frame.setVisible(false);
  }
}
