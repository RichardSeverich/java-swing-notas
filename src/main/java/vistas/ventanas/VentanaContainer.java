package vistas.ventanas;

public class VentanaContainer {

  public static VentanaContainer ventanaContainer;

  public Ventana ventanaLogin;
  public Ventana ventanaDashboard;
  
  private VentanaContainer(){
    this.ventanaLogin = new VentanaLogin();
    this.ventanaDashboard = new VentanaDashboard();
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
  }

}
