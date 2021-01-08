package vistas.ventanas;

public class VentanaContainer {
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

  private VentanaContainer(){
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
  }

  public static VentanaContainer getInstancia(){
      if(ventanaContainer == null){
          ventanaContainer = new VentanaContainer();
      }
      return ventanaContainer;
  }

  public void cerrarVentanas(){
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
  }
}
