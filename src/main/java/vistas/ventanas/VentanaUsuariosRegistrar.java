package vistas.ventanas;

import javax.swing.JFrame;

import vistas.componentes.ComponentesUsuariosRegistrar;

public class VentanaUsuariosRegistrar extends VentanaDashboard {

  public VentanaUsuariosRegistrar(){
    super();
    this.frame.setSize(550, 600);
    ComponentesUsuariosRegistrar.set(this); 
  }

}
