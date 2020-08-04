package vistas.ventanas;

public class VentanaContainer {

  public static VentanaContainer ventanaContainer;

  public Ventana ventanaLogin;
  public Ventana ventanaDashboard;
  public Ventana ventanaUsuariosRegistrar;
  public Ventana ventanaUsuariosMostrar;
  
  private VentanaContainer(){
    this.ventanaLogin = new VentanaLogin();
    this.ventanaDashboard = new VentanaDashboard();
    this.ventanaUsuariosRegistrar = new VentanaUsuariosRegistrar();
    this.ventanaUsuariosMostrar = new VentanaUsuariosMostrar();
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
  }

}
