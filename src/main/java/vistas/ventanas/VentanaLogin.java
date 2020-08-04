package vistas.ventanas;

import javax.swing.JFrame;

import vistas.componentes.ComponentesLogin;

public class VentanaLogin extends Ventana {

  public VentanaLogin(){
    super("Ventana Login"); 
    this.frame.setSize(320, 180);
    ComponentesLogin.set(this);
  }

}
