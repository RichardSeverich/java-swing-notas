package vistas.ventanas;

import javax.swing.JFrame;

import vistas.componentes.ComponentesDashboard;

public class VentanaDashboard extends Ventana {

  public VentanaDashboard(){
    super("Dashboard"); 
    this.frame.setSize(900, 720);
    this.frame.setLayout(null);
    ComponentesDashboard.set(this); 
  }

}
