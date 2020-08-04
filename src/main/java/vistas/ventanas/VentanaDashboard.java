package vistas.ventanas;

import javax.swing.JFrame;

import vistas.componentes.ComponentesDashboard;

public class VentanaDashboard extends Ventana {

  public VentanaDashboard(){
    super("Ventana Dashboard"); 
    this.frame.setSize(852, 480);
    ComponentesDashboard.set(this); 
  }

}
