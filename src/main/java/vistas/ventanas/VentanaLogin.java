package vistas.ventanas;

import vistas.componentes.ComponentesLogin;

/**
* Class.
*/
public class VentanaLogin extends Ventana {

  /**
  * Constructor.
  */
  public VentanaLogin() {
    super("Login");
    this.frame.setSize(320, 180);
    this.frame.setLocationRelativeTo(null);
    ComponentesLogin.set(this);
  }
}
