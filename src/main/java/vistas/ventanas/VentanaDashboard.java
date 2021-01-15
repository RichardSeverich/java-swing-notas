package vistas.ventanas;

import vistas.componentes.ComponentesDashboard;

/**
* Class.
*/
public class VentanaDashboard extends Ventana {

  /**
  * Constructor.
  */
  public VentanaDashboard() {
    super("Dashboard");
    this.frame.setSize(900, 720);
    this.frame.setLayout(null);
    this.frame.setLocationRelativeTo(null);
    ComponentesDashboard.set(this);
  }
}
