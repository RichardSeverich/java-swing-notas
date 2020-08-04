package vistas.ventanas;

public class VentanaContainer {

  public static VentanaContainer ventanaContainer;

  public Ventana ventanaLogin;
  public Ventana ventanaDashboard;
  public Ventana VentanaUsuariosRegistrar;
  
  private VentanaContainer(){
    this.ventanaLogin = new VentanaLogin();
    this.ventanaDashboard = new VentanaDashboard();
    this.VentanaUsuariosRegistrar = new VentanaUsuariosRegistrar();
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
    this.VentanaUsuariosRegistrar.frame.setVisible(false);
  }

}
