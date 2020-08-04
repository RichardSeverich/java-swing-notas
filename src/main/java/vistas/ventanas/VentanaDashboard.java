package vistas.ventanas;

import javax.swing.JFrame;

import vistas.componentes.ComponentesDashboard;

public class VentanaDashboard extends Ventana {

  public VentanaDashboard(){
    super("Dashboard"); 
    this.frame.setSize(1280, 720);
    ComponentesDashboard.set(this); 
  }

}
