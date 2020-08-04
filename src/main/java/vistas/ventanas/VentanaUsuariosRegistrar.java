package vistas.ventanas;

import javax.swing.JFrame;

import vistas.componentes.componentesUsuariosRegistrar;

public class VentanaUsuariosRegistrar extends VentanaDashboard {

  public VentanaUsuariosRegistrar(){
    super();
    this.frame.setSize(550, 600);
    componentesUsuariosRegistrar.set(this); 
  }

}
